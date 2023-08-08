package algorithm_imp.common_algo_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 6.最小生成树 (普利姆算法)
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] chars = {'A', 'B', 'C', 'D', 'E'};
        int[][] side = {{10, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        PGraph pGraph = new PGraph(chars, side);
        primAlgorithm(pGraph, 0);
    }

    public static void primAlgorithm(PGraph graph, int v) {
        int[] visit = new int[graph.getVertexNum()];
        visit[v] = 1;
        int h1 = 0;
        int h2 = 0;
        int minWight = 1000;
        int vertexNum = graph.getVertexNum();
        int[][] side = graph.getSide();
        char[] vertex = graph.getVertex();
        //得到vertexNum-1条边
        for (int i = 1; i < vertexNum; i++) {
            //遍历所有结点先找到一个访问过的结点 然后再遍历所有结点 找到一个未访问过的结点
            //在当前访问过的结点与所有结点的之间边的权值中找到最小的 用h1 h2记录该边的两个结点
            //以及该结点间的最小权值 简单来说就是遍历所有访问过的结点相连的没有访问过的解点之间的权
            //得到最小的权 以及顶点 算是找到一个最小生成树的边 将该边的另一端结点设置为访问过
            //继续遍历 直到找到n-1条边
            for (int j = 0; j < vertexNum; j++) {
                if (visit[j] != 1)
                    continue;
                for (int k = 0; k < vertexNum; k++) {
                    if (visit[k] == 0 && side[j][k] < minWight) {
                        h1 = j;
                        h2 = k;
                        minWight = side[i][j];
                    }
                }
            }
            System.out.println(h1 + " " + h2 + " " + minWight);
            minWight = 1000;
            visit[h2] = 1;
        }

    }
}


class PGraph {
    private int vertexNum;
    private char[] vertex;
    private int[][] side; //邻接矩阵

    public PGraph(char[] vertex, int[][] side) {
        this.vertex = vertex;
        this.side = side;
        vertexNum = vertex.length;
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
}
