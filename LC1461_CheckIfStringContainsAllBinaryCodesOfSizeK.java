package practise.src.main.java.leetCode;

import java.util.HashSet;

public class LC1461_CheckIfStringContainsAllBinaryCodesOfSizeK {
    public static void main(String[] args) {
        String s = "00110110";
        int k = 2;
        System.out.println(hasAllCodes(s, k));
    }

    private static boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        if (s.length() < k) return false;
        HashSet<String> st = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            st.add(sub);

            if (st.size() == need) {
                return true;
            }
        }
        return false;
    }
}
