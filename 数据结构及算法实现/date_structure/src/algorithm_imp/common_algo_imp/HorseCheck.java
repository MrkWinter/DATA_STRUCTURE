package algorithm_imp.common_algo_imp;

import java.awt.*;
import java.util.*;

/**
 * @author MrkWinter
 * @version 1.0
 * 10. 马踏棋盘算法
 */
public class HorseCheck {
    private final static int SIZE = 64;
    private static boolean visit[][] = new boolean[8][8];
    private static boolean finish = false;

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        horseCheck(board, 3, 3);
    }

    public static void horseCheck(int[][] board, int x, int y) {
        if (board == null || x < 0 || x > Math.abs(board.length) || y < 0 || y > Math.abs(board.length))
            return;
        Position.board = board;
        horseCheck(board, x, y, 1);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    //board为棋盘 n为步数 x y 为坐标
    private static void horseCheck(int[][] board, int x, int y, int n) {
        //走当前位置
        board[x][y] = n;
        //先走然后判断  不能n == 65留到下一次  尽量留到本次递归结束 不然容易出错
        //一共64个格子 不能走到65步
        if (n == SIZE) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println("============================");
            finish = true;
            return;
        }
        //获取下次可能位置
        ArrayList<Position> position = getPosition(board, x, y);
        //Collections.sort(position);
        sortPositions(board, position);
        Position pos = null;
        for (int i = 0; i < position.size(); i++) {
            pos = position.get(i);
            if (!finish) {
                horseCheck(board, pos.x, pos.y, n + 1);
                //回溯表示路走不通 或者已经得到解 清除上步影响
                //若路已经走通 不再递归
                if (!finish)
                    //路已经走通 证明因为走通而回溯 不再消除上步影响
                    board[pos.x][pos.y] = 0;
            }
        }
        //循环结束表示该点所有路均走过若是为死路 消除本步影响
        //若是得到解 则不用消除本步影响
        if (!finish) {
            //设置finish类变量表示结束 不设置变量 全部递归完成 求得所有解
            //board[x][y] = 0;
        }


        //这里有两种回溯方法
        //1. 在循环内回溯 如果有出现回溯 则证明上一步是死路 上一步坐标回溯
        //2. 在循环外回溯 如果出了循环 则证明本位置为死路 这一步回溯
        //若想保留原数组中步数据需要两步
        //1. 防止回溯不断递归 影响数据
        //2. 防止回溯时因判断为死路 消除步数影响
    }

    //设计一个方法返回当前位置马可走的位置
    @SuppressWarnings("all")
    public static ArrayList<Position> getPosition(int[][] board, int x, int y) {
        ArrayList<Position> positions = new ArrayList<>();
        //8个位置判断是否为0 0可以走 其他数表示走过 不能走
        int len = board.length;
        if (x + 2 < len && y + 1 < len && board[x + 2][y + 1] == 0) {
            positions.add(new Position(x + 2, y + 1));
        }
        if (x + 1 < len && y + 2 < len && board[x + 1][y + 2] == 0) {
            positions.add(new Position(x + 1, y + 2));
        }
        if (x - 1 >= 0 && y + 2 < len && board[x - 1][y + 2] == 0) {
            positions.add(new Position(x - 1, y + 2));
        }
        if (x - 2 >= 0 && y + 1 < len && board[x - 2][y + 1] == 0) {
            positions.add(new Position(x - 2, y + 1));
        }
        if (x - 2 >= 0 && y - 1 >= 0 && board[x - 2][y - 1] == 0) {
            positions.add(new Position(x - 2, y - 1));
        }
        if (x - 1 >= 0 && y - 2 >= 0 && board[x - 1][y - 2] == 0) {
            positions.add(new Position(x - 1, y - 2));
        }
        if (x + 1 < len && y - 2 >= 0 && board[x + 1][y - 2] == 0) {
            positions.add(new Position(x + 1, y - 2));
        }
        if (x + 2 < len && y - 1 >= 0 && board[x + 2][y - 1] == 0) {
            positions.add(new Position(x + 2, y - 1));
        }
        return positions;
    }

    public static void sortPositions(int[][] board, ArrayList<Position> positions) {
        //排序方法 插入排序
        Position insert = null;
        int insertIndex = 0;
        for (int i = 1; i < positions.size(); i++) {
            insert = positions.get(i);
            insertIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (getPosition(board, positions.get(j).x, positions.get(j).y).size()
                        > getPosition(board, insert.x, insert.y).size()) {
                    positions.set(j + 1, positions.get(j));
                    insertIndex = j;
                }
            }
            if (insertIndex != i) {
                positions.set(insertIndex, insert);
            }
        }
    }
}

class Position implements Comparable<Position> {
    public int x;
    public int y;
    public static int[][] board;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Position o) {
        //this - o 降序 o - this 升序
        return HorseCheck.getPosition(board, this.x, this.y).size() - HorseCheck.getPosition(board, o.x, o.y).size();
    }
}
