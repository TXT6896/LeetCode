package tao.easy;

/**
 * 只出现一次的数字
 * 最优解法 异或
 */
public class Solution10 {

    public static void main(String[] args) {

    }

    /**
     * hash
     */
/*    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], true);
            } else {
                map.put(nums[i], false);
            }
        }
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) return entry.getKey();
        }
        return -1;
    }*/

    /**
     * 异或
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length < 2) return ans;
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
