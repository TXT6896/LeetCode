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

    /**
     * 双指针 左右两边指针从边界往中间移动，每次移动计算当前容器大小并比较当前最大值，计算后，移动高度较低的指针
     * 原理在于，容器大小取决于 Math.min(height[left], height[right]) * (right - left),当移动较大值时候，
     * x轴一定减小，而高度只会更小或不变，所以移动高度较小的指针才能找到更大的容积
     * @param height
     * @return
     */
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
