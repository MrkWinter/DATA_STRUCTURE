package algorithm_imp.algo_problems_imp;

import java.io.*;
import java.util.*;

/**
 * @author MrkWinter
 * @version 1.0
 * 6. 哈夫曼编码问题
 */
public class HuffmanEncoding {
    private HashMap<Byte, String> hashMap = new HashMap<>();
    private StringBuffer strBuf = new StringBuffer();
    private int huffmanCodeEndDigit;

    //根据字字节数组生成对应的哈夫曼树 返回哈夫曼树的根结点
    private Node createHuffmanTree(byte[] bytes) {
        //统计数组中元素个数
        HashMap<Byte, Integer> hashMap = new HashMap<>();
        for (byte date : bytes) {
            Integer count = hashMap.get(date);
            if (count == null) {
                hashMap.put(date, 1);
            } else {
                hashMap.put(date, count + 1);
            }
        }
        ArrayList<Node> nodes = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : hashMap.entrySet()) {
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
        //叶子结点！！！！！！！！！！！！ 得到编码
        if (node.getLeft() == null && node.getRight() == null) {
            hashMap.put(node.getData(), tempStr.toString());
        }
        if (node.getLeft() != null) {
            setHuffmanCode(node.getLeft(), "0", tempStr);
        }
        if (node.getRight() != null) {
            setHuffmanCode(node.getRight(), "1", tempStr);
        }
    }

    //得到哈夫曼编码的 hashMap
    private HashMap<Byte, String> createHuffmanCode(byte[] bytes) {
        Node huffmanTree = createHuffmanTree(bytes);
        setHuffmanCode(huffmanTree, "", strBuf);
        return hashMap;
    }

    public HashMap<Byte, String> getHuffmanCode() {
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

    //将字节数组信息压缩成成字节数组
    public byte[] huffmanCodeZip(byte[] bytes) {
        HashMap<Byte, String> huffmanCode = createHuffmanCode(bytes);
        StringBuilder strBui = new StringBuilder();
        String s = "";
        //将字节数组根据哈夫曼编码转换成二进制字符串
        for (byte key : bytes) {
            //图片文件转换成bytes数组后 在根据哈夫曼编码表读取时有null 添加到strBui导致出错
            s = huffmanCode.get(key);
            strBui.append(s);
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
    private String byteToBitString(byte b, boolean flag) {
        int temp = b;
        if (flag) {
            temp = 256 | b;//正数补位 负数不改 256 -为 10000000
        } else {
            temp = (int) Math.pow(2, huffmanCodeEndDigit) | b;
        }
        String str = Integer.toBinaryString(temp); //将int数字转换成二进制补码字符串
        //如果补码的最前位为0则会自动省略 这也是上面要补位的原因
        //负数的源码第一位符号位为1 补码也是1 所以负数不需要补位
        //但正数的源码符号位为0 补码也为0 因为省略得不到正确长度的字符串 所以进行补位 在较高位上添加一个1 得到合适长度的字符串
        if (flag) {
            return str = str.substring(str.length() - 8);
        } else {
            return str = str.substring(str.length() - huffmanCodeEndDigit);
        }
    }

    //根据哈夫曼编码和字节数组进行解码
    public byte[] deHuffmanCode(HashMap<Byte, String> hashMap, byte[] huffmanByteArr) {
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
        HashMap<String, Byte> rHashMap = new HashMap<>();
        for (Map.Entry<Byte, String> entry : hashMap.entrySet()) {
            rHashMap.put(entry.getValue(), entry.getKey());
        }
        ArrayList<Byte> bytesList = new ArrayList<>();
        //对二进制字符串进行解码
        int start = 0;
        for (int i = 1; i <= strBui.length(); i++) {
            //subString的特性(前闭后开)要i可以= str.length()
            String substring = strBui.substring(start, i);
            Byte b = rHashMap.get(substring);
            if (null != b) {
                bytesList.add(b);
                start = i;
            }
        }
        byte[] deBytes = new byte[bytesList.size()];
        for (int i = 0; i < deBytes.length; i++) {
            deBytes[i] = bytesList.get(i);
        }
        return deBytes;
    }

    //文件的压缩
    public void huffmanFileZip(String src, String desc) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(desc);
            oos = new ObjectOutputStream(fos);
            //读文件内容
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            //编码内容 得到压缩数组和哈夫曼编码
            byte[] zipBytes = huffmanCodeZip(bytes);
            HashMap<Byte, String> huffmanCode = getHuffmanCode();
            //以对象流的形式写入
            oos.writeObject(zipBytes);
            oos.writeObject(huffmanCode);

            fis.close();
            fos.close();
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void huffmanFileDeZip(String src, String desc) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        ObjectInputStream oos = null;
        try {
            fos = new FileOutputStream(desc);
            fis = new FileInputStream(src);
            oos = new ObjectInputStream(fis);
            //读压缩数据
            byte[] zipBytes = (byte[]) oos.readObject();
            //读编码数据
            HashMap<Byte, String> huffmanCode = (HashMap<Byte, String>) oos.readObject();
            //解压
            byte[] deBytes = deHuffmanCode(huffmanCode, zipBytes);
            fos.write(deBytes);
            fos.close();
            fis.close();
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void preOrder(Node node) {
        if (node != null) {
            node.preOrder();
        }
    }
}

class Node implements Comparable<Node> {
    private byte data;//数据
    private int value;//权值
    private Node left;
    private Node right;

    public Node(byte data, int value) {
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

    public byte getData() {
        return data;
    }

    public void setData(byte data) {
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
