package practise.src.main.java.leetCode;

//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000

import java.util.HashMap;

public class LC13_RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int output = romanToInt(s);
        System.out.println(output);
        System.out.println(System.currentTimeMillis());
        System.out.println(System. nanoTime());
    }

    private static int romanToInt(String s) {
        if(s.length() >= 1 && s.length() <= 15) {
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
            int i, out = 0;
            for (i = 0; i < s.length() - 1; i++) {
                if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                    out = out + map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                    i++;
                    if (i == s.length() - 1)
                        return out;
                } else
                    out = out + map.get(s.charAt(i));
            }
            return out + map.get(s.charAt(s.length() - 1));
        }
        return 0;
    }
}
