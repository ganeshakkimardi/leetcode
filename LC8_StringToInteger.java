package practise.leetCode;


public class LC8_StringToInteger {
    public static void main(String[] args) {
        String s = "";
        System.out.println(myAtoi(s));
    }

    private static int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0)
            return 0;
        int sign = 1;
        long res=0;
        int i = 0;
        if(s.charAt(0) == '-') { sign = -1; i++;}
        else if (s.charAt(0) == '+') { i++; }
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') {
                res = res * 10 + (ch - '0');
                if(sign * res > Integer.MAX_VALUE) { return Integer.MAX_VALUE; }
                else if (sign * res < Integer.MIN_VALUE) { return Integer.MIN_VALUE; }
                i++;
            } else
                break;
        }
        return (int) ((int) sign * res);
    }
}
