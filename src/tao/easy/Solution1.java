package tao.easy;


/**
 * 罗马数字转阿拉伯数字
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.romanToInt("MCMXCIV"));
        Object student = new Student();
        System.out.println(student instanceof Student);
    }

    public int romanToInt(String s) {
        int sum = 0;
        int pre = getValue(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int curr = getValue(s.charAt(i));
            if (pre >= curr) {
                sum += pre;
            }
            if (pre < curr) {
                sum -= pre;
            }
            pre = curr;
        }
        sum += pre;
        return sum;

    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
