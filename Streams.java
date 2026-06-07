package practise.leetCode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,20,31,22,12,3,31,4,28);
        Optional<Integer> sum =  list.stream().reduce((a, b) -> a+b);
        System.out.println(sum);

        //square and display if > 100
        System.out.println("square and display if > 100");
        System.out.println(list.stream()
                .map(e -> e * e)
                .filter(e -> e > 100)
                .mapToInt(e -> e)
                .average()
                .getAsDouble());

        //odd and even
        System.out.println("even");
        List<Integer> even = list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> odd = list.stream()
                .filter(e -> e % 2 != 0)
                .collect(Collectors.toList());
        System.out.println(even);

        //numbers starts with prefix 2
        System.out.println("numbers starts with prefix 2");
        List<Integer> noStartsWith2 = list.stream()
                .map(e -> String.valueOf(e))
                .filter(e -> e.startsWith("2") || e.startsWith("-2"))
                .map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(noStartsWith2);

        //find duplicates
        System.out.println("find duplicates");
        Set<Integer> duplicates = list.stream()
                .filter(e-> Collections.frequency(list, e)>1)
                .collect(Collectors.toSet());
        System.out.println(duplicates);

        //max and min
        System.out.println("max:: "+ list.stream()
                .max(Comparator.comparing(Integer::valueOf)).get());
        System.out.println("min:: "+ list.stream()
                .min(Comparator.comparing(Integer::valueOf)).get());
        System.out.println("min:: " + list.stream()
                .min((a,b) -> a.compareTo(b)).get());

        // sort asc and desc
        System.out.println("ascending sort : " + list.stream()
                .sorted().collect(Collectors.toList()));

        System.out.println("descending sort: " + list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList()));

        //get first 5 numbers and then their sum
        List<Integer> l = list.stream()
                .limit(5).collect(Collectors.toList());
        System.out.println(l);
        System.out.println("sum of first 5 elements is :: " +
                l.stream().reduce((a,b) -> a + b).get());

        //skip first 5 elements
        List<Integer> sk = list.stream().skip(5).collect(Collectors.toList());
        System.out.println(sk);

        //get second highest and lowest
        int secHigh = list.stream()
                .sorted(Collections.reverseOrder()).distinct()
                .skip(1).findFirst().get();
        System.out.println("secHigh:: " + secHigh);

        int secLow = list.stream()
                .sorted().distinct().skip(1).findFirst().get();
        System.out.println("secLow :: " + secLow);

        String str = "pprogramming";
        System.out.println("frequency of each characters in string");
        Map<Character, Long> map = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        System.out.println("first non repetitive character");
        java.lang.Character result = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println(result);

        System.out.println("duplicates");
        Set<Character> set = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toSet());
        System.out.println(set);
    }
}
