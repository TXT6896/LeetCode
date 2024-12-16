package tao.algorithm.easy;

/**
 * 斐波那契数
 */
public class Solution19 {
    public int fib(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;
        return fib(n - 1) + fib(n - 2);
    }


    /**
     * 更优秀的解法，不需要去递归，循环计算所有结果直接返回，没有栈帧得创建删除，效率更高
     *
     * @param n
     * @return
     */
    public int fib2(int n) {

        if (n <= 1) return n;

        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }


}
