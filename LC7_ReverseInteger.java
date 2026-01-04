package practise.leetCode;

public class LC7_ReverseInteger {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverseInteger(x));
    }

    private static int reverseInteger(int x) {
        int rev = 0;
        while(x != 0) {
            if(rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10)
                return 0;
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return rev;
    }
}
