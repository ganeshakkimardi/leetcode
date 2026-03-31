package practise.leetCode;

import java.util.HashMap;

public class LC409_LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
    public static int longestPalindrome(String s) {
//        int out = 0;
//        boolean flag = true;
//        HashMap<Character, Integer> map = new HashMap<>();
//        for(Character ch : s.toCharArray()) {
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//
//        for(int value : map.values()) {
//            if(value % 2 == 0) {
//                out += value;
//            } else {
//                flag = false;
//                out += value - 1;
//            }
//        }
//        return flag ? out : out + 1;

        int count = 0;
        int[] array = new int[128];

        for(Character ch : s.toCharArray()) {
            array[ch]++;
        }
        int isOddPresent = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0) count += array[i];
            else {
                isOddPresent = 1;
                count += array[i] - 1;
            }
        }
        return count += isOddPresent;
    }
}
