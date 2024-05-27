package tao.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 *
 * @author tao
 */
public class Solution29 {

    public static void main(String[] args) {

        Solution29 solution29 = new Solution29();

        int[][] array = new int[][]{
                {2, 3},
                {5, 5},
                {2, 2},
                {3, 4},
                {3, 4}
        };
        int[][] merge = solution29.merge(array);
        System.out.println(Arrays.deepToString(merge));
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0] != 0 ? a[0] - b[0] : a[1] - b[1]);
        int[][] list = new int[intervals.length][2];
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i < intervals.length - 1 && end >= intervals[i + 1][0]) {
                if (end < intervals[i + 1][1]) {
                    end = intervals[i + 1][1];
                }
                i++;
            }
            int[] merge = {start, end};
            list[index++] = merge;
        }
        return Arrays.copyOf(list, index);
    }

    /**
     * 高手写的
     * @param intervals
     * @return
     */
    public int[][] merge2(int[][] intervals) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[1]);
        }
        int[] mins = new int[max + 1];
        int[] maxs = new int[mins.length];
        for (int[] interval : intervals) {
            mins[interval[0]]++;
            maxs[interval[1]]++;
        }
        List<int[]> merged = new ArrayList<>();
        int start = -1, count = 0;
        for (int i = 0; i < mins.length; i++) {
            if (mins[i] > 0) {
                if (count == 0) {
                    start = i;
                }
                count += mins[i];
            }
            if (maxs[i] > 0) {
                count -= maxs[i];
                if (count == 0) {
                    merged.add(new int[] {start, i});
                }
            }
        }
        return merged.toArray(new int[0][]);
    }
}
