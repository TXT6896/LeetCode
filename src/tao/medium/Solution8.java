package tao.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 电话号码的字母组合
 */
public class Solution8 {

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.letterCombinations("").toString());
    }

    public List<String> letterCombinations(String digits) {
        String[] numbers = digits.split("");
        ArrayList<String> list = new ArrayList<>();
        if (numbers.length <= 0) return list;
        list.addAll(Arrays.asList(getStr(numbers[0])));
        for (int i = 1; i < numbers.length; i++) {
            list = combine(list,numbers[i]);
        }

        return list;
    }

    public ArrayList<String> combine(List<String> list,String s) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] str = getStr(s);
        for (int i = 0; i < list.size(); i++) {
            for (int i1 = 0; i1 < str.length; i1++) {
                arrayList.add(list.get(i)+str[i1]);
            }
        }
        return arrayList;
    }

    public String[] getStr(String s) {
        return switch (s) {
            case "2" -> new String[]{"a", "b", "c"};
            case "3" -> new String[]{"d", "e", "f"};
            case "4" -> new String[]{"g", "h", "i"};
            case "5" -> new String[]{"j", "k", "l"};
            case "6" -> new String[]{"m", "n", "o"};
            case "7" -> new String[]{"p", "q", "r", "s"};
            case "8" -> new String[]{"t", "u", "v"};
            case "9" -> new String[]{"w", "x", "y", "z"};
            default -> new String[]{};
        };
    }
}
