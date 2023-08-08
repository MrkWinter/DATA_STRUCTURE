package algorithm_imp.common_algo_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 8.最短路径问题 (弗洛伊德算法)
 */

public class FLoydAlgorithm {
    private static final int INT = 65535;

    @SuppressWarnings("all")
    public static void main(String[] args) {
        char[] chars = {'A', 'B', 'C', 'D', 'E'};
        int[][] side = {{INT, INT, 10, 5, 6},
                {INT, INT, 3, 8, INT},
                {10, 3, INT, 4, 7},
                {5, 8, 4, INT, INT},
                {6, INT, 7, INT, INT}};
        FGraph fGraph = new FGraph(chars, side);
        //传入图
        FloydArr floydArr = floydAlo(fGraph);
        showShort(fGraph, floydArr);
    }

    public static FloydArr floydAlo(FGraph graph) {
        FloydArr floydArr = new FloydArr(graph);
        //三层for循环找每一个中间结点 求最短路径
        int vertexNum = graph.getVertexNum();
        int[][] dis = floydArr.getDis();
        int[][] pre = floydArr.getPre();
        int len = 0;
        for (int i = 0; i <vertexNum; i++) {
            //i 为中间结点
            for (int j = 0; j <vertexNum; j++) {
                //j 为起始结点
                for (int k = 0; k < vertexNum; k++) {
                    //k终止结点
                    len= dis[j][i]+dis[i][k];
                    if(len<dis[j][k]) { //两段和小于一段和 变更最短路径
                        dis[j][k] = len;
                        pre[j][k] = pre[i][k]; //前驱结点不太好理解 i为中间结点
                        /*P[j][k]表示j到k的前驱节点，P[i][k]表示i到k的前驱节点，
                        现在我们j到k是经过i的，因此j到k的前驱节点就必须更新为i到k的前驱节点，
                        因为是经过i才到的k啊*/
                    }
                }
            }
        }
        return floydArr;
    }

    @SuppressWarnings("all")
    public static void showShort(FGraph graph, FloydArr floydArr) {
        int[][] dis = floydArr.getDis();
        System.out.println("各个顶点的前驱结点矩阵如下");
        int[][] pre = floydArr.getPre();
        for (int i = 0; i < pre.length; i++) {
            System.out.print(graph.getVertex()[i] + "为起点：");
            for (int j = 0; j < pre[0].length; j++) {
                System.out.print(graph.getVertex()[j] + "(" + pre[i][j] + ") ");
            }
            System.out.println();
        }
        System.out.println("各个结点的最短路径矩阵如下");
        for (int i = 0; i < dis.length; i++) {
            System.out.print(graph.getVertex()[i] + "为起点：");
            for (int j = 0; j < dis[0].length; j++) {
                System.out.print(graph.getVertex()[j] + "(" + dis[i][j] + ") ");
            }
            System.out.println();
        }
    }
}

//数组结果辅助
class FloydArr {
    private static final int INT = 65535;

    private int[][] dis;//和邻接表一样大 不断更新 为各个顶点到各个顶点最短路径的距离表
    private int[][] pre;//和邻接表一样大 不断更新 为各个顶点为起点的最短路径的前驱结点表

    public FloydArr(FGraph graph) {
        //根据图创建表进行操作
        int vertexNum = graph.getVertexNum();
        //初始化距离表
        dis = new int[vertexNum][vertexNum];
        int[][] matrix = graph.getMatrix();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                dis[i][j] = matrix[i][j];
            }
        }
        //初始化前驱表
        pre = new int[vertexNum][vertexNum];
        for (int i = 0; i < pre.length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    public int[][] getDis() {
        return dis;
    }

    public void setDis(int[][] dis) {
        this.dis = dis;
    }

    public int[][] getPre() {
        return pre;
    }

    public void setPre(int[][] pre) {
        this.pre = pre;
    }
}

class FGraph {
    private static final int INT = 65535;
    private char[] vertex;//顶点
    private int[][] matrix; //最短路径表 和 开始和临街矩阵相同 不断修改
    private int vertexNum;

    public FGraph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
        this.vertexNum = vertex.length;
    }

    public char[] getVertex() {
        return vertex;
    }

    public void setVertex(char[] vertex) {
        this.vertex = vertex;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }
}