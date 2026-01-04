package practise.leetCode;

public class LC5_LargestPalindromeInGivenString {
    public static void main(String[] args) {
        String str = "babad";
        str = largestPalindromeInString(str);
        System.out.println(str);
    }

    private static String largestPalindromeInString(String str) {
        Integer i, low, high;
        String pa = "", palindrome = "";
        if (str.length() == 1)
            return str;
        else {
            for (i = 1; i < str.length(); i++) {
                // palindrome of odd length
                low = high = i;

                while (str.charAt(low) == str.charAt(high)) {
                    low--;
                    high++;

                    if (low < 0 || high == str.length())
                        break;
                }
                pa = str.substring(low + 1, high);
                if (pa.length() > palindrome.length())
                    palindrome = pa;

                // palindrome of even length
                low = i - 1;
                high = i;

                while (str.charAt(low) == str.charAt(high)) {
                    low--;
                    high++;

                    if (low < 0 || high == str.length())
                        break;
                }
                pa = str.substring(low + 1, high);
                if (pa.length() > palindrome.length())
                    palindrome = pa;
            }
            return palindrome;
        }
    }

}