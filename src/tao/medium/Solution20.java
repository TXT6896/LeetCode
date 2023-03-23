package tao.medium;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 最大子数组和
 */
public class Solution20 {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            integers.add(0,9);
        }
        System.out.println(integers.size());
    }

    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int curr = max;
        int start = 0;
        int temp = start;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0 && nums[start] <= 0) {
                curr = curr + nums[i] - nums[start];
                max = Math.max(max, curr);
                start++;
                continue;
            }
            if (nums[i] < 0 && nums[start] > 0) {
                    curr += nums[i];
                continue;
            }
            if (nums[i] >= 0 && nums[start] <= 0) {
                curr = curr + nums[i] - nums[start];
                max = Math.max(max, curr);
                start++;
                continue;
            }
            if (nums[i] >= 0 && nums[start] > 0) {
                if (curr<0){
                    start = i;
                    curr = nums[i];
                }else {
                    curr += nums[i];
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}
