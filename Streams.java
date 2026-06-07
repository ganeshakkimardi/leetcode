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
        java.lang.Character result = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap:: new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println(result);

        System.out.println("duplicates");
        Set<Character> set = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toSet());
        System.out.println(set);

        System.out.println("duplicate int");
        List<Integer> numbers = Arrays.asList(1,2,3,4,2,5,3,6,6);
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates1 = numbers.stream().filter(n -> !seen.add(n)).collect(Collectors.toList());
        List<Integer> duplicates2 = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(n -> n.getValue() > 1).map(n -> n.getKey()).collect(Collectors.toList());
        System.out.println(duplicates1);
        System.out.println(duplicates2);

        System.out.println("second highest number");
        int secondHighest = numbers.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().orElse(-1);
        System.out.println(secondHighest);

        System.out.println("longest string");
        List<String> words = Arrays.asList("Java","SpringBoot","Microservices");
        String longest = words.stream().max(Comparator.comparing(String::length)).orElse("");
        System.out.println(longest);

        System.out.println("Join Strings with Comma");
        String result1 = words.stream().collect(Collectors.joining(", "));
        System.out.println(result1);

        List<Employee> employees = Arrays.asList(

                new Employee(101, "John", 75000, Department.IT, 28),
                new Employee(102, "David", 90000, Department.IT, 35),
                new Employee(103, "Emma", 65000, Department.HR, 30),
                new Employee(104, "Sophia", 120000, Department.FINANCE, 40),
                new Employee(105, "James", 85000, Department.SALES, 32),
                new Employee(106, "Olivia", 95000, Department.IT, 27),
                new Employee(107, "Michael", 70000, Department.HR, 29),
                new Employee(108, "William", 110000, Department.FINANCE, 45),
                new Employee(109, "Ava", 60000, Department.ADMIN, 26),
                new Employee(110, "Lucas", 80000, Department.SALES, 33)

        );
        System.out.println("sorting employees on salary ASC");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        System.out.println("sorting employees on salary DESC");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);

        System.out.println("employee with highest salary");
        System.out.println(employees.stream().max(Comparator.comparing(Employee::getSalary)).map(Employee::getName).get());

        System.out.println("group by dept");
        Map<Department, List<Employee>> deptMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(deptMap);

        System.out.println("Partition Numbers into Even and Odd");
        Map<Boolean, List<Integer>> result2 = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(result2);
    }
}
