package tao.algorithm.medium;

/**
 * 不同路径
 */
public class Solution19 {

    public int uniquePaths(int m, int n) {
        int[] res = {0};
        backtrack(1, 1, m, n, res);
        return res[0];
    }

    public void backtrack(int x, int y, int m, int n, int[] res) {
        if (x == m && y == n) {
            res[0]++;
            return;
        }
        if (x == m) {
            backtrack(x, y + 1, m, n, res);
            return;
        }
        if (y == n) {
            backtrack(x + 1, y, m, n, res);
            return;
        }
        backtrack(x + 1, y, m, n, res);
        backtrack(x, y + 1, m, n, res);
    }

}

