package algorithm_imp.common_algo_imp;


import java.time.chrono.MinguoDate;
import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 6.最小生成树 (克鲁斯卡尔算法)
 */
@SuppressWarnings("all")
public class KruskalAlgorithm {
    private static int INT = Integer.MIN_VALUE;

    public static void main(String[] args) {
        char[] chars = {'A', 'B', 'C', 'D', 'E'};
        int[][] side = {{0, INT, 10, 5, 6},
                {INT, 0, 3, 8, INT},
                {10, 3, 0, 4, 7},
                {5, 8, 4, 0, INT},
                {6, INT, 7, INT, 0}};
        KGraph kGraph = new KGraph(chars, side);
        kruskalAlg(kGraph);
    }

    public static void kruskalAlg(KGraph graph) {
        EDate[] eDates = graph.geteDates();
        graph.sortEDate(eDates);
        EDate[] retDate = new EDate[graph.getVertexNum()-1];
        int[] ends = new int[graph.getVertexNum()];
        int index = 0;
        for (int i = 0; i < graph.getSideNum(); i++) {
            int p1 = graph.getIndex(eDates[i].getStart());
            int p2 = graph.getIndex(eDates[i].getEnd());
            //获取终点
            int m = graph.getEnd(ends, p1);
            int n = graph.getEnd(ends, p2);
            //克鲁斯卡尔重要算法
            //以知边的求解过程中求的到边的顶点总是start > end
            //第一轮
            //若两顶点终点不同 则将ends数组中较小的顶点下标标记为较大的结点
            //第二轮
            //其边的结点出现上轮出现的较小结点时 返回的就是最小生成树子图中该点的顶点
            //根据另一个结点的大小分为两种情况
            //顶点好像并不是联通图中的最大下标值 只是保证了联通图中所有顶点指向了一点 从而达到判断两个顶点是否都已经在图中
            if (m != n) {
                ends[m] = n; //该步骤让n成为各个子图中的顶点
                retDate[index++] = eDates[i];
            }
        }
        System.out.println(Arrays.toString(retDate));
    }
}

@SuppressWarnings("all")
class KGraph {
    private static int INT = Integer.MIN_VALUE;
    private int vertexNum;
    private char[] vertex;
    private int[][] side; //邻接矩阵
    private int sideNum;

    public KGraph(char[] vertex, int[][] side) {
        this.vertex = vertex;
        this.side = side;
        vertexNum = vertex.length;
        for (int i = 0; i < side.length; i++) {
            for (int j = i + 1; j < side[0].length; j++) {
                if (side[i][j] != INT) {
                    sideNum++;
                }
            }
        }

    }

    //得到边的数组
    public EDate[] geteDates() {
        EDate[] eDates = new EDate[sideNum];
        for (int i = 0; i < eDates.length; i++) {
            eDates[i] = new EDate();
        }
        int index = 0;
        for (int i = 0; i < side.length; i++) {
            for (int j = i + 1; j < side[0].length; j++) {
                if (side[i][j] != INT) {
                    eDates[index].setStart(vertex[i]);
                    eDates[index].setEnd(vertex[j]);
                    eDates[index++].setWeight(side[i][j]);
                }
            }
        }
        return eDates;
    }

    //对边数组进行排序
    public void sortEDate(EDate[] eDate) {
        for (int i = eDate.length - 1; i > 0; i--) {
            EDate maxDate = eDate[0];
            int minIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (eDate[j].getWeight() > maxDate.getWeight()) {
                    maxDate = eDate[j];
                    minIndex = j;
                }
            }
            eDate[minIndex] = eDate[i];
            eDate[i] = maxDate;
        }
    }

    //根据字符得到顶点下标
    public int getIndex(char a) {
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == a) {
                return i;
            }
        }
        return -1;
    }

    //得到顶点的终点的值 克鲁斯卡尔重要算法
    public int getEnd(int[] end, int i) {
        while (end[i] != 0) {
            i = end[i];
        }
        return i;
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }

    public char[] getVertex() {
        return vertex;
    }

    public void setVertex(char[] vertex) {
        this.vertex = vertex;
    }

    public int[][] getSide() {
        return side;
    }

    public void setSide(int[][] side) {
        this.side = side;
    }

    public int getSideNum() {
        return sideNum;
    }

    public void setSideNum(int sideNum) {
        this.sideNum = sideNum;
    }
}

@SuppressWarnings("all")
class EDate {
    private char start;
    private char end;
    private int weight;

    public EDate(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public EDate() {
    }

    public char getStart() {
        return start;
    }

    public char getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setStart(char start) {
        this.start = start;
    }

    public void setEnd(char end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "EDate{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}