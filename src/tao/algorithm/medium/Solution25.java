package tao.algorithm.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小路径和
 */
public class Solution25 {

    private Integer sum = 0;
    private Integer m;
    private Integer n;

    private Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String s = new String("123");
        String s1 = new String("123");
        String s2 = "123";
        String s3 = "123";
        System.out.println(s==s1);
        System.out.println(s1==s2);
        System.out.println(s2==s3);

        Double i1 = 100.00;
        Double i2 = 100.00;
        Double i3 = 200.00;
        Double i4 = 200.00;
        System.out.println(i1==i2);
        System.out.println(i3==i4);
    }
    /**
     * 我的回溯超时
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < n; i++) {
            sum+=grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            sum += grid[i][n-1];
        }
        minPathSum(grid[0][0], grid, 0, 0);
        return sum;
    }

    public void minPathSum(Integer sum, int[][] grid, int i, int j) {
        if (sum > this.sum) return;
        if ((i + 1) == m && (j + 1) == n) {
            this.sum = sum;
            return;
        }
        if ((j + 1) < n) {
            minPathSum(sum + grid[i][j + 1], grid, i, j + 1);
        }
        if ((i + 1) < m) {
            minPathSum(sum + grid[i + 1][j], grid, i + 1, j);
        }
    }


    /**
     * 别人的 动态规划解法
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
