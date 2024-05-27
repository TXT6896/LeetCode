package tao.medium;

/**
 * @description：编辑距离
 * @author： tao
 * @create： 2023/11/21 18:59
 */
public class Solution31 {


    public static void main(String[] args) {
        int[][] ints = new int[1][2];
        System.out.println(ints[0][1]);
    }

    public int minDistance(String word1, String word2) {
        //声明一个二维数组存放将word1前i个字母转换成word2前j个字符所需要的最小步数
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        //边界情况
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i - 1][j], dp[i][j - 1]))+1;
                }
            }
        }
        return dp[m][n];
    }


    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity];
    }
}
