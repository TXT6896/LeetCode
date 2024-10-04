package tao.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class Solution30 {

    private static ArrayList<String> result = new ArrayList();


    public static void main(String[] args) {
        Solution30 so = new Solution30();
        List<String> list = so.generateParenthesis(1);
        System.out.println(list);
    }

    public List<String> generateParenthesis(int n) {
        result.clear();
        String s = "(";
        generate(n, 1, 0, s);
        return result;
    }

    public void generate(int n, int left, int right, String s) {

        if (s.length() >= n * 2) {
            result.add(s);
            return;
        }
        if (left == right) {
            s = s + "(";
            generate(n, left + 1, right, s);
            return;
        }
        if (left == n) {
            s = s + ")";
            generate(n, left, right + 1, s);
            return;
        }


        String s1 = s + "(";
        generate(n, left + 1, right, s1);

        String s2 = s + ")";
        generate(n, left, right + 1, s2);
    }
}
