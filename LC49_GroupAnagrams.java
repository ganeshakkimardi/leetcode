package practise.leetCode;

import java.util.*;

public class LC49_GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> out = new HashMap<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if (!out.containsKey(key))
                out.put(key, new ArrayList<>());
            out.get(key).add(s);
        }
        return new ArrayList<>(out.values());
    }
}
