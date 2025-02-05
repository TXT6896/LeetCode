package tao.algorithm.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description：739.每日温度
 * @author： tao
 * @create： 2024/12/9 11:19
 */
public class Solution38 {
    /**
     * 方法一：暴力循环，双重循环数组，找到最近大于当前温度的元素下标，时间复杂度O(n2),空间复杂度O(n)
     * 方法二：利用栈，具体看题解，z
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[]{};
        //保存结果
        int[] res = new int[temperatures.length];
        //栈，这里使用Deque性能更高
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            //栈不为空且栈顶元素小于当前元素
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            //比较完后入栈
            stack.push(i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] res = new int[10];
        System.out.println(Arrays.toString(res));
    }
}
