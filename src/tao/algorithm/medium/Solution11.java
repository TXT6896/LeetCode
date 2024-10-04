package tao.algorithm.medium;

/**
 * 下一个排列
 */
public class Solution11 {

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] nums = {1,2,3};
        solution11.nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {
        boolean flag = true;
        //int min = nums[nums.length-1];

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = i,k = 0; j < (nums.length - i) / 2 + i; j++) {
                    int temp = nums[j];
                    nums[j] = nums[nums.length - 1 - k];
                    nums[nums.length - 1 - k] = temp;
                    k++;
                }

                int index = i;
                int temp = nums[i - 1];
                while (index <= nums.length - 1) {
                    if (temp < nums[index]) {
                        nums[i - 1] = nums[index];
                        nums[index] = temp;
                        break;
                    }
                    index++;
                }
                flag = false;
                break;
            }
        }
        if (flag) {
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
        }
    }
}
