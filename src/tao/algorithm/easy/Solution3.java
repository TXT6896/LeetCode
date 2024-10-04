package tao.algorithm.easy;

/**
 * 1668.最大重复子字符串
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.maxRepeating("a", "a"));
    }

    public int maxRepeating(String sequence, String word) {

        int maxk = 0;
        for (int i = 0; i < sequence.length(); i++) {
            int temp = i;
            int k = 0;
            while ((sequence.startsWith(word, temp)) && temp < sequence.length()) {
                k++;
                temp = temp + word.length();
            }
            maxk = Math.max(k, maxk);
        }
        return maxk;
    }
}
