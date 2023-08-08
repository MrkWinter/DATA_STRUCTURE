package date_structure_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Tests {
    static char a;

    public static void main(String[] args) {
//        SingleLinkList singleLinkList = new SingleLinkList();
//        singleLinkList.putValueByNo(new HeroNode(1,"张三"));
//        singleLinkList.putValueByNo(new HeroNode(2,"张三"));
//        singleLinkList.putValueByNo(new HeroNode(3,"张三"));
//        singleLinkList.putValueByNo(new HeroNode(4,"张三"));
//        singleLinkList.showLinkList();
////        HeroNode valueEndByN = singleLinkList.getValueEndByN(2);
////        System.out.println(valueEndByN);
//        singleLinkList.reverseLinkList();
//        singleLinkList.showLinkList();
//        singleLinkList.reversePrint(singleLinkList.getHeadNode());
//        singleLinkList.reversePrint2(singleLinkList.getHeadNode());
//        HashLinkList hashLinkList = new HashLinkList();
//        hashLinkList.add(new Emp(1,"w"));
//        hashLinkList.update(1,"d");
//        System.out.println(hashLinkList.select(1));
//        hashLinkList.list();
//        hashLinkList.delete(1);
//        HashTable hashTable = new HashTable(10);
//        hashTable.add(new Emp(1,"w"));
//        hashTable.update(1,"d");
//        System.out.println(hashTable.select(1));
//        hashTable.delete(1);
//        hashTable.add(new Emp(1,"w"));
//        hashTable.add(new Emp(1,"w"));
//        hashTable.add(new Emp(1,"w"));
//        hashTable.add(new Emp(1,"w"));
//        hashTable.list();

//        BinaryTree binaryTree = new BinaryTree();
//        PeopleNode node1 = new PeopleNode(1, "w");
//        PeopleNode node2 = new PeopleNode(2, "e");
//        PeopleNode node3 = new PeopleNode(3, "r");
//        PeopleNode node4 = new PeopleNode(4, "t");
//        PeopleNode node5 = new PeopleNode(5, "y");
//        binaryTree.setRoot(node1);
//        node1.setLeft(node2);
//        node1.setRight(node3);
//        node3.setRight(node4);
//        node3.setLeft(node5);
//        binaryTree.posOrder();
//        PeopleNode peopleNode = binaryTree.posSearch(210);
//        System.out.println(peopleNode);
//        binaryTree.delete(4);
//        binaryTree.preOrder();
//        int[] arr = {1,2,3,4,5,6,7,8};
//        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
//        arrayBinaryTree.preOrder();
//        arrayBinaryTree.midOrder();
//        arrayBinaryTree.porOrder();
//        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
//        PoNode node1 = new PoNode(1, "w");
//        PoNode node2 = new PoNode(2, "e");
//        PoNode node3 = new PoNode(3, "r");
//        PoNode node4 = new PoNode(4, "t");
//        PoNode node5 = new PoNode(5, "y");
//        threadedBinaryTree.setRoot(node1);
//        node1.setLeft(node2);
//        node1.setRight(node3);
//        node3.setRight(node5);
//        node3.setLeft(node4);
//        threadedBinaryTree.porThreadBinaryTree();
//        threadedBinaryTree.porThreadOrder();
//        int[] arr = {1,3,8,2,0,4};
//        HuffmanTree huffmanTree = new HuffmanTree();
//        huffmanTree.createHuffmanTree(arr);
//        huffmanTree.preOrder();
//        HuffmanEncoding huffmanEncoding = new HuffmanEncoding();
//        huffmanEncoding.preOrder(huffmanEncoding.createHuffmanTree("adfddfa dfasddsf asdfas".toCharArray()));
//        System.out.println(a == '\u0000');
//        HuffmanEncoding huffmanEncoding = new HuffmanEncoding();
//        Map<Character, String> huffmanCode = huffmanEncoding.createHuffmanCode("qs cvbngds wrtyuw agfhjyj sdadacv uyngfbf");
//        for (Map.Entry entry : huffmanCode.entrySet()) {
//            System.out.println(entry.getKey().toString() + ":" + entry.getValue());
//        }
//        HuffmanEncoding huffmanEncoding = new HuffmanEncoding();
//        huffmanEncoding.createHuffmanCode("abcdefg");
//        huffmanEncoding.showHuffmanCode();
//        HuffmanEncoding huffmanEncoding = new HuffmanEncoding();
//        byte[] bytes = huffmanEncoding.huffmanCodeZip("I love you");
//        HashMap<Character,String> huffmanMap = huffmanEncoding.getHuffmanCode();
//        String s = huffmanEncoding.deHuffmanCode(huffmanMap, bytes);
//        System.out.println(s);
//
//        System.out.println(Integer.toBinaryString(-1));
//        System.out.println(Integer.parseInt("000111111",2));
//        HuffmanEncoding huffmanEncoding = new HuffmanEncoding();
//        huffmanEncoding.huffmanStringZip("test.txt","test.zip");
//        byte[] bytes = {2,3,52,74};
//        String str = bytes.toString();
//        System.out.println(str);
//        byte[] bytes1 = str.getBytes();
//        System.out.println(Arrays.toString(bytes1));
//        HuffmanEncoding huffmanEncoding = new HuffmanEncoding();
//        byte[] bytes = huffmanEncoding.huffmanCodeZip("I love you".getBytes());
//        byte[] bytes1 = huffmanEncoding.deHuffmanCode(huffmanEncoding.getHuffmanCode(), bytes);
//        for (int i = 0; i < bytes1.length; i++) {
//            System.out.print((char) bytes1[i]);
//        }
//        huffmanEncoding.huffmanFileZip("hello.txt","hello.zip");
//        huffmanEncoding.huffmanFileDeZip("hello.zip","helllo1.txt");
//        huffmanEncoding.huffmanFileZip("xier.jpg","xier.zip");
//        huffmanEncoding.huffmanFileDeZip("xier.zip","xier2.jpg");
//        AVLTree binarySortTree = new AVLTree();
//        binarySortTree.createBinarySortTree(new int[]{1, 7, 2, 4, 8, 0});
//        binarySortTree.deleteANode(2);
//        System.out.println(binarySortTree.getRoot().getLeftHigh() + " " + binarySortTree.getRoot().getRightHigh());

        Graph graph = new Graph(5);
        graph.addVertex("A","B","C","D","E");
        System.out.println(graph.getVertexList());
        graph.addEdges(0,1,1);
        graph.addEdges(0,2,1);
        graph.addEdges(1,2,1);
        graph.addEdges(1,3,1);
        graph.addEdges(1,4,1);
        graph.showEdges();
        graph.dfsAroundGraph();
        graph.deConnectDfsAroundGraph();
        graph.bfsAroundGraph();
        graph.deConnectBfsAroundGraph();
    }
}
