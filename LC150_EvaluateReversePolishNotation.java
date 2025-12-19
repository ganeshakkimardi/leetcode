package practise.src.main.java.leetCode;

import java.util.Stack;

public class LC150_EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    private static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String ch : tokens) {
            if (ch.equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if (ch.equals("-")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if (ch.equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if (ch.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.parseInt(ch));
            }
        }
        return stack.peek();
    }
}
