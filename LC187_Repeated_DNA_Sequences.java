package practise.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC187_Repeated_DNA_Sequences {
    public static void main(String[] args) {
        String s ="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }

    private static List<String> findRepeatedDnaSequences(String s) {
        Set<String> seenSequence = new HashSet<>();
        Set<String> repeatedSequence = new HashSet<>();

        for (Integer i = 0; i <= s.length()-10; i++) {
            String subString = s.substring(i, i+10);
            if (!seenSequence.add(subString))
                repeatedSequence.add(subString);
        }
        return new ArrayList<>(repeatedSequence);
    }
}
