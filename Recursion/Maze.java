package Recursion;

//递归解决迷宫问题
public class Maze {
    public static void main(String[] args) {
        //创建二维数组模拟迷宫地图
        int maze[][] = new int[8][8];
        //1:墙 0:可走路线 2:实际路线
        //将地图边缘置1
        for (int i = 0; i < 8; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
            maze[i][0] = 1;
            maze[i][7] = 1;
        }
        for (int i = 1; i < 4; i++) {
            maze[3][i] = 1;
        }
        //打印地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        //使用递归回溯
        Play(maze, 1, 1);
        //输出新的迷宫地图,并标记走过的路线
        System.out.println("结果");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * @param maze
     * @param i    起始位置x坐标
     * @param j    起始位置y坐标
     * @return 到达终点返回true否则返回false
     */
    public static boolean Play(int[][] maze, int i, int j) {
        if (maze[6][6] == 2) {
            return true;
        } else {
            if (maze[i][j] == 0) {
                maze[i][j] = 2;
                if (Play(maze, i + 1, j)) {//下
                    return true;
                } else if (Play(maze, i, j + 1)) {//右
                    return true;
                } else if (Play(maze, i - 1, j)) {//上
                    return true;
                } else if (Play(maze, i, j - 1)) {//左
                    return true;
                } else {//该点无法走通
                    maze[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
