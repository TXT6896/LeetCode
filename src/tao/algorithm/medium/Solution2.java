package tao.algorithm.medium;

/**
 * Z字形变换
 */
public class Solution2 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.convert(s, 4));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == 1) {
            return s;
        }
        if (numRows >= s.length()) {
            return s;
        }
        /*
        规律就是纵列到斜列的间距是 (numRows - (i + 1) % numRows) * 2
        纵列到纵列的间距是 2 * numRows - 2
         */
        StringBuilder sb = new StringBuilder();
        int temp;
        for (int i = 0; i < numRows - 1; i++) {
            temp = i;
            int num1 = (numRows - (i + 1) % numRows) * 2;
            int num2 = 2 * numRows - 2;
            sb.append(s.charAt(i));
            while ((num1 + temp) < s.length() && (num2 + temp) < s.length()) {
                if (num1 == num2) {
                    sb.append(s.charAt(temp + num2));
                } else {
                    sb.append(s.charAt(temp + num1)).append(s.charAt(temp + num2));
                }
                temp = temp + num2;
            }
            if ((num1 + temp) < s.length()) {
                sb.append(s.charAt(temp + num1));
            }
            if ((num2 + temp) < s.length()) {
                sb.append(s.charAt(num2 + temp));
            }
        }
        //最后一行
        temp = numRows - 1;
        while (temp < s.length()) {
            sb.append(s.charAt(temp));
            temp = temp + 2 * numRows - 2;
        }
        return sb.toString();
    }
}
