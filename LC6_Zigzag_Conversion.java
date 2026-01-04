package practise.leetCode;

public class LC6_Zigzag_Conversion {
    public static void main(String[] args) {
        Integer numrows = 4;
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, numrows));
    }

    private static String convert(String s, Integer numRows) {
        String[] ans = new String[numRows];
        for (int i = 0; i< numRows; i++)
            ans[i] = "";

        int i=0;
        while(i < s.length()) {
            for(int index = 0; index < numRows && i< s.length(); index++) {
                ans[index]+= s.charAt(i++);
            }
            for (int index = numRows - 2; index > 0 && i < s.length(); index--) {
                ans[index]+= s.charAt(i++);
            }
        }
        String res = "";
        for(String str : ans)
            res += str;
        return res;
    }
}
