package tao.algorithm.medium;


import java.util.*;

/**
 * 电话号码的字母组合
 */
public class Solution8 {

    public static void main(String[] args) throws NoSuchFieldException {

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

    class Solution {
        public List<String> generateParenthesis(int n) {
            if (n == 1) {
                return Arrays.asList("()");
            }
            Set<String> hs = new HashSet<>();
            for (String s : generateParenthesis(n-1)) {
                for (int i = 0; i < 2*n-2; i++) {
                    hs.add(s.substring(0,i) + "()" + s.substring(i,s.length()));
                }
            }
            return new ArrayList(hs);
        }
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
        String[] result;
        switch (s) {
            case "2":
                result = new String[]{"a", "b", "c"};
                break;
            case "3":
                result = new String[]{"d", "e", "f"};
                break;
            case "4":
                result = new String[]{"g", "h", "i"};
                break;
            case "5":
                result = new String[]{"j", "k", "l"};
                break;
            case "6":
                result = new String[]{"m", "n", "o"};
                break;
            case "7":
                result = new String[]{"p", "q", "r", "s"};
                break;
            case "8":
                result = new String[]{"t", "u", "v"};
                break;
            case "9":
                result = new String[]{"w", "x", "y", "z"};
                break;
            default:
                result = new String[]{};
        }
        return result;
    }
}
