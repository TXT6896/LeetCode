package tao.medium;

import java.util.*;

/**
 * 字母异位词分组
 */
public class Solution18 {

    public static void main(String[] args) {
        String[] strs = new String[]{"","",""};
        Solution18 so = new Solution18();
        System.out.println(so.groupAnagrams(strs).toString());
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List res = new ArrayList<>();
        HashMap<Integer, String> temp = new HashMap<>();
        ArrayList<String> strList = new ArrayList<>(Arrays.asList(strs));
/*        for (int i = 0; i < strList.size(); i++) {
            if (temp.containsKey(i)) continue;
            ArrayList<String> list = new ArrayList<>();
            list.add(strList.get(i));
            for (int j = 0; j < strList.size(); j++) {
                if (i == j) continue;
                if (temp.containsKey(j)) continue;
                if (isSame(strList.get(i), strList.get(j))) {
                    temp.put(j,strList.get(j));
                    list.add(strList.get(j));
                }
            }*/

        while(strList.size() > 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(strList.get(0));
            for (int j = 1; j < strList.size(); j++) {
                if (isSame(strList.get(0), strList.get(j))) {
                    list.add(strList.get(j));
                    strList.remove(j);
                    j = 0;
                }
            }
            res.add(list);
            strList.remove(0);
        }
        return res;
    }

/*    public List<List<String>> groupAnagrams(String[] strs) {
        List res = new ArrayList<>();
        Arrays.sort(strs);
        strs.
    }*/
    public boolean isSame(String s1, String s2) {
        if (null == s1 || null == s2) return false;
        if (s1.length() != s2.length()) return false;
        String[] arr1 = s1.split("");
        String[] arr2 = s2.split("");
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }
}
