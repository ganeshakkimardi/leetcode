package practise.leetCode;

import java.util.*;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int poppedValue = stack.pop();
        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class LC155_MinStack {
    public static void main(String[] args) {

        // Simulating input:
        String[] ops = {"MinStack","push","push","push","getMin","pop","top","getMin"};
        int[][] values = { {}, {-2}, {0}, {-3}, {}, {}, {}, {} };

        MinStack obj = null;

        List<String> output = new ArrayList<>();

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "MinStack":
                    obj = new MinStack();
                    output.add("null");
                    break;

                case "push":
                    obj.push(values[i][0]);
                    output.add("null");
                    break;

                case "pop":
                    obj.pop();
                    output.add("null");
                    break;

                case "top":
                    output.add(String.valueOf(obj.top()));
                    break;

                case "getMin":
                    output.add(String.valueOf(obj.getMin()));
                    break;
            }
        }

        System.out.println(output);
    }
}
