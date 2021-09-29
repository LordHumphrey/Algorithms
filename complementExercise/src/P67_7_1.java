import java.util.Stack;

public class P67_7_1 {
    Stack<Integer> mainStack, helpStack;

    public static void main(String[] args) {
        P67_7_1 test = new P67_7_1();
        test.push(1);
        test.push(2);
        System.out.println(test.peek());
        System.out.println(test.pop());
        System.out.println(test.empty());

    }

    public P67_7_1() {
        this.mainStack = new Stack<>();
        this.helpStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
    }

    public int pop() {
        int first;
        if (helpStack.empty()) {
            while (!mainStack.empty()) {
                helpStack.add(mainStack.pop());
            }

        }
        first = helpStack.pop();
        return first;
    }

    public int peek() {
        int first;
        if (helpStack.empty()) {
            while (!mainStack.empty()) {
                helpStack.add(mainStack.pop());
            }

        }
        first = helpStack.peek();
        return first;
    }

    public boolean empty() {
        return mainStack.empty()&& helpStack.empty();
    }
}
