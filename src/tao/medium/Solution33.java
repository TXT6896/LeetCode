package tao.medium;

/**
 * 岛屿数量
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 * @description：TODO
 * @author： tao
 * @create： 2023/12/6 15:06
 */
public class Solution33 {

    public static void main(String[] args) {
        String s = "project_position_objective_relation";
        System.out.println(s.length());
    }

    public int numIslands(char[][] grid) {
        //岛屿数量
        int n = 0;
        //遍历所有岛屿
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    n++;
                }
            }
        }
        return n;
    }

    public void dfs(char[][] grid, int i, int j) {
        //结束条件
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] != '1') return;
        //标记遍历过的陆地
        grid[i][j] = '2';
        //遍历上下左右
        //上
        dfs(grid, i + 1, j);
        //下
        dfs(grid, i - 1, j);
        //左
        dfs(grid, i, j - 1);
        //右
        dfs(grid, i, j + 1);
    }


}
