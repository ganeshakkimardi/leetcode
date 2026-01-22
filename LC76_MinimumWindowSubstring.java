package practise.src.main.java.leetCode;


public class LC76_MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        if(s.isEmpty() || s.length() < t.length() || t.isEmpty())
            return new String();
        int start = 0, end = 0, count = t.length(), minLen = Integer.MAX_VALUE, startIndex = 0;
        int[] map = new int[128];

        for(char c : t.toCharArray())
            map[c]++;

        char[] chS = s.toCharArray();
        while(end < chS.length) {
            if(map[chS[end++]]-- > 0) {
                count--;
            }

            while(count == 0) {
                if(end - start < minLen) {
                    startIndex = start;
                    minLen = end - startIndex;
                }
                if(map[chS[start++]]++ == 0)
                    count++;
            }
        }
        return minLen == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minLen);
    }
}
