package tao.medium;

/**
 * 旋转图像
 */
public class Solution17 {

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1,2,3};
        matrix[1] = new int[]{4,5,6};
        matrix[2] = new int[]{7,8,9};
        Solution17 so = new Solution17();
        so.rotate(matrix);

    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //上下翻转
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - i][j];
                matrix[len - 1 - i][j] = temp;
            }
        }
        //对角线反转
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void rotate(int[][] matrix, int n, int index) {
        if (n <= 1) return;
        rotate(matrix, n - 2, index + 1);
        for (int i = 0; i < n - 1; i++) {
            int pre = matrix[index + i][index + n - 1];
            matrix[index + i][index + n - 1] = matrix[index][index + i];
            int curr = matrix[index + n - 1][n - i - 1];
            matrix[index + n - 1][n - i - 1] = pre;
            pre = curr;
            curr = matrix[n - i - 1][index];
            matrix[n - i - 1][index] = pre;
            pre = curr;
            matrix[index][index + i] = pre;
        }
    }
}
