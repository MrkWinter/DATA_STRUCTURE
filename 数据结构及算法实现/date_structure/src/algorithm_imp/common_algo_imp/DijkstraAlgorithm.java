package algorithm_imp.common_algo_imp;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author MrkWinter
 * @version 1.0
 * 8. 最短路径（迪杰斯特拉算法）
 */
public class DijkstraAlgorithm {
    private static final int INT = 65535;

    public static void main(String[] args) {
        char[] chars = {'A', 'B', 'C', 'D', 'E'};
        int[][] side = {{INT, INT, 10, 5, 6},
                {INT, INT, 3, 8, INT},
                {10, 3, INT, 4, 7},
                {5, 8, 4, INT, INT},
                {6, INT, 7, INT, INT}};
        DGraph dGraph = new DGraph(side, chars);
        //辅助数组集
        VertexArray vertexArray = dijkstraAlg(dGraph, 4);
        //显示最短路径
        showShortest(dGraph, vertexArray);

    }

    //graph图  begin是出发位置
    public static VertexArray dijkstraAlg(DGraph graph, int begin) {
        //得到顶点辅助数组集
        VertexArray v = new VertexArray(graph.getVertexNum(), begin);
        //通过图更新辅助数组集
        graph.updateVertexArray(begin, v);
        int minIndex = 0;
        for (int i = 0; i < graph.getVertexNum() - 1; i++) {
            minIndex = v.getMinVertex();
            graph.updateVertexArray(minIndex, v);
        }

        return v;
    }

    //根据辅助数组集和图显示最短路径
    public static void showShortest(DGraph graph, VertexArray v) {
        int[] preVisit = v.getPreVisit();
        System.out.println("前驱结点数组表示");
        for (int i = 0; i < preVisit.length; i++) {
            System.out.print(graph.getVertex()[i] + "(" + preVisit[i] + ") ");
        }
        System.out.println();
        int[] dis = v.getDis();
        System.out.println("最短路径数组表示");
        for (int i = 0; i < dis.length; i++) {
            System.out.print(graph.getVertex()[i] + "(" + dis[i] + ") ");
        }
        System.out.println();
    }

}

//辅助结点数组集
class VertexArray {
    private static final int INT = 65535;
    private int[] isVisit;
    private int[] dis; //最短路径数组
    private int[] preVisit; //前驱结点数组

    //begin是开始访问结点下标
    public VertexArray(int vertexNum, int begin) {
        isVisit = new int[vertexNum];
        dis = new int[vertexNum];
        preVisit = new int[vertexNum];
        //初始化访问过结点数组
        isVisit[begin] = 1;
        //初始化最短路径数组
        Arrays.fill(dis, INT);
        dis[begin] = 0;
        //初始化前驱结点数组
        Arrays.fill(preVisit, -1);
    }

    //找到和开始结点最短路径的结点(固定了的结点) 下标
    public int getMinVertex() {
        int index = -1;
        int minDis = INT;
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] < minDis && isVisit[i] == 0) {
                minDis = dis[i];
                index = i;
            }
        }
        return index;
    }

    //判断顶点是否访问过
    public boolean isVisit(int n) {
        return isVisit[n] == 1;
    }

    //更新其他结点到起始结点的距离
    public void updateDis(int index, int length) {
        dis[index] = length;
    }

    //更新前驱结点
    public void updatePre(int index, int pre) {
        preVisit[index] = pre;
    }

    //返回出发结点到index结点之间的距离
    public int getLenDis(int index) {
        return dis[index];
    }

    public int[] getIsVisit() {
        return isVisit;
    }

    public void setIsVisit(int[] isVisit) {
        this.isVisit = isVisit;
    }

    public int[] getDis() {
        return dis;
    }

    public void setDis(int[] dis) {
        this.dis = dis;
    }

    public int[] getPreVisit() {
        return preVisit;
    }

    public void setPreVisit(int[] preVisit) {
        this.preVisit = preVisit;
    }
}

//图
class DGraph {
    private static final int INT = 65535;

    private int[][] matrix;
    private char[] vertex;
    private int vertexNum;

    public DGraph(int[][] matrix, char[] vertex) {
        this.matrix = matrix;
        this.vertex = vertex;
        vertexNum = vertex.length;
    }

    //更新访问结点后的最短路径数组和前驱结点数组
    public void updateVertexArray(int index, VertexArray v) {
        //该结点已经访问
        v.getIsVisit()[index] = 1;
        //更新最短路径数组
        //访问所有结点
        int len = 0;
        for (int i = 0; i < v.getDis().length; i++) {
            if (!v.isVisit(i)) {//该结点没有访问过
                len = v.getLenDis(index) + matrix[index][i];//开始结点到该结点的距离 + 该结点的距离到各个结点的距离
                if (len < v.getLenDis(i)) {
                    //更新最短路径
                    v.updateDis(i, len);
                    //更新前驱访问结点
                    v.updatePre(i, index);
                }
            }
        }
    }

    public void showGraph() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public char[] getVertex() {
        return vertex;
    }

    public void setVertex(char[] vertex) {
        this.vertex = vertex;
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }
}