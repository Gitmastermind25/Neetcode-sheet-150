package stack;

import java.util.*;

public class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            if (val < min) min = val;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop = stack.pop();

        if (pop < 0) min = min - pop;
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinStack minStack = new MinStack();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String op = sc.next();

            switch (op) {
                case "push":
                    int val = sc.nextInt();
                    minStack.push(val);
                    break;

                case "pop":
                    minStack.pop();
                    break;

                case "top":
                    System.out.println(minStack.top());
                    break;

                case "getMin":
                    System.out.println(minStack.getMin());
                    break;
            }
        }
        sc.close();
    }
}