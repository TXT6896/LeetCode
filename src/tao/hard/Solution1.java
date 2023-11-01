package tao.hard;

import java.util.UUID;

/**
 * 寻找两个正序数组的中位数
 */
public class Solution1 {

    public static void main(String[] args) {
        System.out.println("sh2772249816850134344065195".length());
        System.out.println(UUID.randomUUID().toString());

    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0, j = 0, z = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                arr[z++] = nums1[i++];
                continue;
            }
            arr[z++] = nums2[j++];
        }
        while (i < nums1.length) {
            arr[z++] = nums1[i++];
        }
        while (j < nums2.length) {
            arr[z++] = nums2[j++];
        }

        if (arr.length % 2 == 0) return (double) (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2;

        return arr[arr.length / 2];
    }


}
