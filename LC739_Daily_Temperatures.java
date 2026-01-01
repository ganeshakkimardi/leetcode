package practise.src.main.java.leetCode;

import java.util.Arrays;
import java.util.Stack;

public class LC739_Daily_Temperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        Arrays.stream(dailyTemperatures(temperatures)).forEach(System.out::print);

    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                results[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return results;
    }
}
