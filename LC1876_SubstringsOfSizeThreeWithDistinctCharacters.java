package practise.src.main.java.leetCode;

import java.util.HashMap;

public class LC1876_SubstringsOfSizeThreeWithDistinctCharacters {
    public static void main(String[] args) {
        String s = "aababcabc";
        System.out.println(countGoodSubstrings(s));
    }

    private static int countGoodSubstrings(String s) {
//        int n = s.length();
//        if(n < 3) return 0;
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        int left = 0, count = 0;
//        for(int right = 0; right < n; right++) {
//            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
//
//            //when window size is = 3
//            if(right - left + 1 == 3) {
//                if(map.size() == 3) count++;
//                int freq = map.get(s.charAt(left));
//                if(freq == 1){
//                    map.remove(s.charAt(left));
//                } else {
//                    map.put(s.charAt(left), freq - 1);
//                }
//                left++;
//            }
//        }
//        return count;
        int count=0;
        for(int i=0; i<=s.length()-3; i++){
            char a=s.charAt(i);
            char b=s.charAt(i+1);
            char c=s.charAt(i+2);

            if(a!=b && b!=c && a!=c){
                count++;
            }
        }
        return count;
    }
}
