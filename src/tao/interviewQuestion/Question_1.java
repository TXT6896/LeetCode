package tao.interviewQuestion;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 *
 * 示例 1:
 * Plain Text
 * 输入: s = "tree"输出: "eert"解释: 'e'出现两次，'r'和't'都只出现一次。因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 *
 * 示例 2:
 * Plain Text
 * 输入: s = "cccaaa"输出: "cccaaa"解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 *
 *
 * 示例 3:
 * Plain Text
 * 输入: s = "Aabb"输出: "bbAa"解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。注意'A'和'a'被认为是两种不同的字符。
 */
public class Question_1 {

    public static void main(String[] args) {
        String s = "akjshgciajuuuuu0000000000";
        System.out.println(getSortStr(s));
    }

    public static String getSortStr(String s){

        if (s == null || s.equals("")) return "";

        String[] arr = s.split("");
        HashMap<String, String> map = new HashMap<>();

        for (String str : arr) {
            if (map.containsKey(str)){
                map.put(str,map.get(str)+str);
            }else {
                map.put(str,str);
            }
        }
        Collection<String> list = map.values();
        List<String> collect = list.stream().sorted((o1, o2) -> o2.length() - o1.length()).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder("");
        for (String s1 : collect) {
            sb.append(s1);
        }
        return sb.toString();
    }
}
