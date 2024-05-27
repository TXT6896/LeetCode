package tao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationFinder {

    public static void main(String[] args) {
        List<Double> leftValues = Arrays.asList(1907.9, 962.96); // 假设左边有两个元素
        List<Double> rightValues = Arrays.asList(458.97, 413.98, 296.99, 368.98, 278.99, 386.98, 278.99, 296.99,
                161.98, 386.98, 458.98, 296.99, 296.99, 341.98, 296.99); // 假设右边有一组元素

        for (double leftValue : leftValues) {
            // 查找和等于左边单个元素值的所有右边元素的组合
            List<List<Double>> combinations = findCombinations(rightValues, leftValue);
            System.out.println("Combinations for left value " + leftValue + ":");
            for (List<Double> combination : combinations) {
                System.out.println(combination);
            }
        }
    }

    public static List<List<Double>> findCombinations(List<Double> rightValues, double targetSum) {
        List<List<Double>> result = new ArrayList<>();
        backtrack(rightValues, targetSum, new ArrayList<>(), 0, result);
        return result;
    }

    private static void backtrack(List<Double> rightValues, double targetSum, List<Double> currentCombination, int startIndex, List<List<Double>> result) {
        if (targetSum == 0) {
            // 如果当前组合的和等于目标和，则添加到结果中
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = startIndex; i < rightValues.size(); i++) {
            // 防止重复使用右边的元素
            if (currentCombination.contains(rightValues.get(i))) {
                continue;
            }

            double num = rightValues.get(i);
            if (num <= targetSum) {
                // 如果当前元素小于等于目标和，则添加到当前组合中
                currentCombination.add(num);
                // 递归调用，继续查找剩余目标和的组合
                backtrack(rightValues, targetSum - num, currentCombination, i + 1, result);
                // 回溯，撤销选择
                currentCombination.remove(currentCombination.size() - 1);
            }
            // 如果当前元素大于目标和，则无需继续搜索
            // 因为后面的元素都会更大，不可能组成有效组合
        }
    }
}