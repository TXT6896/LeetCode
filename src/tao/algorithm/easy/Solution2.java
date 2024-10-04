package tao.algorithm.easy;

/**
 * 最长公共前缀
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String[] strs = {"flower", "flowc", "flight", "a" };
        System.out.println(solution2.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder pubStr = new StringBuilder();
        boolean flag = true;
        for (int j = 0; j < strs[0].length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                if ((j > strs[i].length() - 1) || (strs[0].charAt(j) != strs[i].charAt(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                pubStr.append(strs[0].charAt(j));
                continue;
            }
            break;
        }
        return pubStr.toString();
    }
}
