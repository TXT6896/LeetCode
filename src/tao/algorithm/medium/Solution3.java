package tao.algorithm.medium;

/**
 * 11. 盛最多水的容器 (双指针）
 */
public class Solution3 {

    public static void main(String[] args) {
        int[] height = new int[]{2,3,4,5,18,17,6};
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.maxArea(height));
    }

    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1, maxCapital = 0, capital;

        while (right != left) {
            capital = Math.min(height[left], height[right]) * (right - left);
            maxCapital = Math.max(maxCapital, capital);
            int i = height[left] <= height[right] ? left++ : right--;
        }

        return maxCapital;
    }
}
