package tao.easy;

/**
 * 回文数
 */
public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.isPalindrome(313));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x > 0 && x % 10 == 0) return false;
        int y = x;
        int temp = 0;
        while (y >= 10) {
            temp = temp * 10 + y % 10;
            y = y / 10;
        }
        temp = temp * 10 + y;
        return temp == x;

    }
}
