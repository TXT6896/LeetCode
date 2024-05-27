package tao.easy;

/**
 * 题号 2698
 *
 * @description：TODO
 * @author： tao
 * @create： 2024/2/19 11:09
 */
public class Solution18 {

    /* 9*9  = 81 , 1+8 = 9 */
/*    static boolean check(int t, int x) {

        if (t == x) return true;

    }*/

    static boolean check(int t, int x) {

        if (t == x) return true;
        int d = 10;
        while (t >= d && t % d <= x) {
            if (check(t / d, x - (t % d))) return true;
            d *= 10;
        }
        return false;
    }
}
