package stack;

import java.util.*;

public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input format: space separated tokens
        // Example: 2 1 + 3 *
        System.out.println("Enter RPN expression (space separated):");
        String input = sc.nextLine();

        String[] tokens = input.split(" ");

        EvalRPN obj = new EvalRPN();
        int result = obj.evalRPN(tokens);

        System.out.println("Result: " + result);

        sc.close();
    }
}
