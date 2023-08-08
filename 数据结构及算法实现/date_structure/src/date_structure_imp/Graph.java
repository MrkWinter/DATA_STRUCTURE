package date_structure_imp;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 13. 图
 */
//临接矩阵表示
public class Graph {
    private int[][] edges; //边
    private ArrayList<String> vertexList; //顶点
    private int edgeNum;
    private int vertexNum;
    private int vertexMaxNum;
    private boolean[] isVisit;

    public Graph(int n) {
        if (n <= 0) {
            throw new RuntimeException("n>0");
        }
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        isVisit = new boolean[n];
        vertexMaxNum = n;
        edgeNum = 0;
        vertexNum = 0;
    }

    //添加顶点
    public void addVertex(String s) {
        vertexList.add(s);
        vertexNum++;
    }

    public void addVertex(String... s) {
        for (int i = 0; i < s.length; i++) {
            addVertex(s[i]);
        }
    }

    public void addVertex(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            addVertex(list.get(i));
        }
    }

    //添加边
    public void addEdges(int row, int col, int weight) {
        edges[row][col] = weight;
        edges[col][row] = weight;
        edgeNum++;
    }

    public void addDirectEdges(int row, int col, int weight) {
        edges[row][col] = weight;
        edgeNum++;
    }

    //得到顶点个数
    public int getVertexList() {
        return vertexList.size();
    }

    //返回边的数目
    public int getEdgeNum() {
        return edgeNum;
    }

    //返回休下标对应的结点
    public String getVertex(int i) {
        return vertexList.get(i);
    }

    //显示边图
    public void showEdges() {
        //Arrays没有遍历二维数组信息的方法
        for (int i = 0; i < edges.length; i++) {
            System.out.println(Arrays.toString(edges[i]));
        }
    }

    //图的深度优先遍历
    public void dfsAroundGraph() {
        if (vertexNum == 0)
            return;
        dfsAroundGraph(0);
        System.out.println();
        Arrays.fill(isVisit, false);
    }

    public void deConnectDfsAroundGraph() {
        if (vertexNum == 0)
            return;
        for (int i = 0; i < vertexNum; i++) {
            dfsAroundGraph(i);
        }
        System.out.println();
        Arrays.fill(isVisit, false);
    }

    private void dfsAroundGraph(int n) {
//        if (((Predicate<boolean[]>) booleans -> {
//            int i = 0;
//            for (i = 0; i < vertexNum; i++) {
//                if (!booleans[i])
//                    break;
//            }
//            return i == vertexNum;
//        }).test(isVisit)) {
//            Arrays.fill(isVisit, false);
//            return;
//        }
        if (!isVisit[n]) {
            System.out.print(vertexList.get(n) + " ");
            isVisit[n] = true;
        }
        for (int i = 0; i < vertexNum; i++) {
            if (edges[n][i] != 0 && !isVisit[i]) {
                dfsAroundGraph(i);
            }
        }
    }

    //图的广度优先遍历
    public void bfsAroundGraph() {
        if (vertexNum == 0)
            return;
        bfsAroundGraph(0, new Queue<Integer>());
        System.out.println();
        Arrays.fill(isVisit, false);
    }

    public void deConnectBfsAroundGraph() {
        if (vertexNum == 0)
            return;
        for (int i = 0; i < vertexNum; i++) {
            bfsAroundGraph(i, new Queue<Integer>());
        }
        System.out.println();
        Arrays.fill(isVisit, false);
    }

    private void bfsAroundGraph(int n, Queue<Integer> queue) {
        if (!isVisit[n]) {
            System.out.print(vertexList.get(n) + " ");
            isVisit[n] = true;
        }
        for (int i = 0; i < vertexNum; i++) {
            if (edges[n][i] != 0 && !isVisit[i]) {
                System.out.print(vertexList.get(i) + " ");
                isVisit[i] = true;
                queue.enqueue(i);
            }
        }
        try {
            if (!queue.isEmpty())
                bfsAroundGraph(queue.dequeue(), queue);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
