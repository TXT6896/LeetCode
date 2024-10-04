package tao.algorithm.sort;

import java.util.HashMap;

/**
 * 基数排序
 */
public class RadixSort {

    public void sort(int[] arr){
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }

    public void sort(int[] arr, int divisor) {
        //创建二维数组作为桶
        int[][] barrel = new int[10][arr.length];
        //一维数组记录每个桶当前元素个数
        int[] barrelCountArray = new int[10];

        //取元素个位放到桶对应下标数组
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] / divisor % 10;
            barrel[digit][barrelCountArray[digit]++] = arr[i];
        }

        int index = 0;
        //将桶中元素放回数组中
        for (int i = 0; i < barrel.length; i++) {
            for (int i1 = 0; i1 < barrelCountArray[i]; i1++) {
                arr[index++] = barrel[i][i1];
            }
        }
    }
}
