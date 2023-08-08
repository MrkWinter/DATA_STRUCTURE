package algorithm_imp;

import java.io.*;
import java.util.*;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class HuffmanEncoding {
    private HashMap<Character, String> hashMap = new HashMap<>();
    private StringBuffer strBuf = new StringBuffer();
    private int huffmanCodeEndDigit;

    //根据字符数组生成对应的哈夫曼树 返回哈夫曼树的根结点
    private Node createHuffmanTree(char[] arr) {
        //统计数组中元素个数
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char date : arr) {
            Integer count = hashMap.get(date);
            if (count == null) {
                hashMap.put(date, 1);
            } else {
                hashMap.put(date, count + 1);
            }
        }
        ArrayList<Node> nodes = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        //添加完毕 将数组构建成哈夫曼树
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.remove(0);
            Node rightNode = nodes.remove(0);
            Node parent = new Node(leftNode.getValue() + rightNode.getValue());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    //得到哈夫曼编码表
    private void setHuffmanCode(Node node, String pathValue, StringBuffer strBuf) {
        if (node == null)
            return;
        StringBuffer tempStr = new StringBuffer(strBuf);
        tempStr.append(pathValue);
        if (node.getData() != '\u0000') {
            hashMap.put(node.getData(), tempStr.toString());
        }
        if (node.getLeft() != null) {
            setHuffmanCode(node.getLeft(), "0", tempStr);
        }
        if (node.getRight() != null) {
            setHuffmanCode(node.getRight(), "1", tempStr);
        }
    }

    //得到哈夫曼编码的hashMap
    public HashMap<Character, String> createHuffmanCode(String str) {
        char[] charArray = str.toCharArray();
        Node huffmanTree = createHuffmanTree(charArray);
        setHuffmanCode(huffmanTree, "", strBuf);
        return hashMap;
    }
    public HashMap<Character, String> createHuffmanCode(char[] chars) {
        Node huffmanTree = createHuffmanTree(chars);
        setHuffmanCode(huffmanTree, "", strBuf);
        return hashMap;
    }

    public HashMap<Character, String> getHuffmanCode() {
        return hashMap;
    }

    //显示哈夫曼编码
    public void showHuffmanCode() {
        if (hashMap.size() == 0) {
            throw new RuntimeException("哈夫曼编码未创建");
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry.getKey().toString() + ":" + entry.getValue());
        }
    }

    //将字符串压缩成成字节数组
    public byte[] huffmanCodeZip(String str) {
        HashMap<Character, String> huffmanCode = createHuffmanCode(str);
        StringBuilder strBui = new StringBuilder();
        //将字符串根据哈夫曼编码转换成二进制字符串
        for (char key : str.toCharArray()) {
            strBui.append(huffmanCode.get(key));
        }
        //计算该字符串转换成字节数组要多大容量
        int len = (strBui.length() + 7) / 8;
        byte[] huffmanByteArr = new byte[len];
        int index = 0;
        String byteString = "";
        for (int i = 0; i < strBui.length(); i += 8) {
            if (i + 8 > strBui.length()) {
                byteString = strBui.substring(i);
                huffmanCodeEndDigit = strBui.length() - i;
            } else {
                byteString = strBui.substring(i, i + 8);
            }
            huffmanByteArr[index++] = (byte) Integer.parseInt(byteString, 2);
            //将byteString当做补码来看 实际转换成byte时看原码
        }
        return huffmanByteArr;
    }


    //解码相关---------------------------------------


    //根据一个byte转换成对应的字符串
    //flag判断是否需要补位 如果是最后一位数则需要特殊补位
    public String byteToBitString(byte b, boolean flag) {
        int temp = b;
        if (flag) {
            temp = 256 | b;//正数补位 负数不改 256 -为 10000000
        }else {
            temp = (int)Math.pow(2,huffmanCodeEndDigit) | b;
        }
        String str = Integer.toBinaryString(temp); //将int数字转换成二进制补码字符串
        //如果补码的最前位为0则会自动省略 这也是上面要补位的原因
        //负数的源码第一位符号位为1 补码也是1 所以负数不需要补位
        //但正数的源码符号位为0 补码也为0 因为省略得不到正确长度的字符串 所以进行补位 在较高位上添加一个1 得到合适长度的字符串
        if (flag) {
            return str = str.substring(str.length() - 8);
        } else {
            return str = str.substring(str.length()-huffmanCodeEndDigit);
        }
    }

    //根据哈夫曼编码和字节数组进行解码
    public String deHuffmanCode(HashMap<Character, String> hashMap, byte[] huffmanByteArr) {
        StringBuilder strBui = new StringBuilder();
        String s = "";
        //得到二进制字符串
        for (int i = 0; i < huffmanByteArr.length; i++) {
            if (i != huffmanByteArr.length - 1) {
                s = byteToBitString(huffmanByteArr[i], true);
            } else {
                s = byteToBitString(huffmanByteArr[i], false);
            }
            strBui.append(s);
        }
        //逆转hashmap
        HashMap<String, Character> rHashMap = new HashMap<>();
        for (Map.Entry entry : hashMap.entrySet()) {
            rHashMap.put((String) entry.getValue(), (Character) entry.getKey());
        }
        StringBuilder decodeStr = new StringBuilder();
        //对二进制字符串进行解码
        int start = 0;
        for (int i = 1; i <= strBui.length(); i++) {
            //subString的特性(前闭后开)要i可以= str.length()
            String substring = strBui.substring(start, i);
            Character c = rHashMap.get(substring);
            if (c != null) {
                decodeStr.append(c);
                start = i;
            }
        }
        return decodeStr.toString();
    }
    //文本文件的压缩
    public void huffmanStringZip(String src,String desc) {
        //把哈夫曼编码byte数组 和 压缩后的字节编码byte数组以对象的形式写入到文件中
        //这里无法实现！！！！ 需要更改结点类型 和 设计类型
        BufferedReader bfr;
        BufferedWriter bfw;
        StringBuilder strBui = new StringBuilder();
        String str = "";
        try {
            bfr = new BufferedReader(new FileReader(src));
            bfw = new BufferedWriter(new FileWriter(desc));
            while((str=bfr.readLine())!=null) {
                strBui.append(str);
            }
            byte[] bytes = huffmanCodeZip(strBui.toString());
            bfw.write("bytes");
            bfr.close();
            bfw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void huffmanStringDeZip(String src,String desc){
     //   !!!!!  需要字节数组设计
    }
    public void preOrder(Node node) {
        if (node != null) {
            node.preOrder();
        }
    }
}

class Node implements Comparable<Node> {
    private char data;//数据
    private int value;//权值
    private Node left;
    private Node right;

    public Node(char data, int value) {
        this.data = data;
        this.value = value;
    }

    public Node(int value) {
        this.value = value;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null)
            this.left.preOrder();
        if (this.right != null)
            this.right.preOrder();
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", value=" + value +
                '}';
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
