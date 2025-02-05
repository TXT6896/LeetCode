package tao.algorithm.medium;

/**
 * @description：43. 字符串相乘
 * @author： tao
 * @create： 2025/1/9 10:32
 */
public class Solution37 {

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";
        String multiply = multiply(s1, s2);
        System.out.println(multiply);
    }

    /**
     * 利用 竖式乘法 规则，使用数组保存乘积
     * @param num1
     * @param num2
     * @return
     */
    public static  String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        //初始化结果数组
        int[] res = new int[m + n];
        //从低位开始做乘法
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //计算乘积
                //计算乘积
                int mutl = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //对应数组两个下表 （这是关键逻辑，）
                int p1 = i + j, p2 = i + j + 1;
                //进位计算
                int sum = res[p2] + mutl;

                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        //高位 0 值处理
        int i = 0;
        while (i < res.length -1 && res[i] == 0) {
            i++;
        }

        //从i开始拼接字符串
        String s = "";
        for (int j = i; j < res.length; j++) {
            s = s + res[j];
        }
        return s;
    }
}
