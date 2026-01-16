package practise.leetCode;

import java.util.HashMap;

public class LC567_PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "abc";
        System.out.println(checkInclusion(s1, s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> s1Count = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            s1Count.put(c, s1Count.getOrDefault(c, 0) + 1);
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            char rc = s2.charAt(right);
            window.put(rc, window.getOrDefault(rc, 0) + 1);

            if (right - left + 1 > s1.length()) {
                char lc = s2.charAt(left);
                window.put(lc, window.get(lc) - 1);
                if (window.get(lc) == 0) {
                    window.remove(lc);
                }
                left++;
            }

            if (window.equals(s1Count)) {
                return true;
            }
        }

        return false;
    }
}
