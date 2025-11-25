package practise.src.main.java.leetCode;

import java.util.HashMap;
//sliding window

public class LC3_LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String str = "pwwkew";
		System.out.println("Length of longest substring: " + lengthOfLongestSubstring(str));
	}

	public static int lengthOfLongestSubstring(String str) {

		Integer i = 0, j = 0, maxLen = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (j = 0; j < str.length(); j++) {
			Character currentChar = str.charAt(j);
			if (map.containsKey(currentChar))
				i = Math.max(i, map.get(currentChar) + 1);
			map.put(currentChar, j);
			maxLen = Math.max(maxLen, j - i + 1);
		}
		return maxLen;

        //

        //		if (str.length() == 1)
//			return 1;
//		else {
//			Integer i, j = 0, len = 0, maxLen = 0;
//			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//
//			for (i = 0; i < str.length(); i++) {
//				j = i;
//				while (!map.containsKey(str.charAt(j)) && j < str.length() - 1) {
//					len++;
//					map.put(str.charAt(j), j);
//					j++;
//				}
//				maxLen = Math.max(maxLen, len);
//				len = 0;
//				if (!map.isEmpty())
//					map.clear();
//			}
//
//			return maxLen;
//		}

        //

	//	using two pointers
//		Integer l = 0,r = 0,maxLength = 0;
//		Map<Character, Integer> map = new HashMap<>();
//		for (r=0;r<str.length();r++) {
//			if (map.containsKey(str.charAt(r))) {
//				map.put(str.charAt(r), r);
//				l=map.get(str.charAt(r));
//			} else {
//				map.put(str.charAt(r), r);
//				maxLength=Math.max(maxLength, r-l+1);
//			}
//		}
//		return maxLength;
	}
}