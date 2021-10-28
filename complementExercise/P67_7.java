import java.util.ArrayDeque;
import java.util.Deque;

public class P67_7 {
    Deque<Integer> mainDeque, helpDeque;

    public static void main(String[] args) {
        P67_7 test = new P67_7();
        test.push(1);
        test.push(2);
        System.out.println(test.top());
        System.out.println(test.pop());
        System.out.println(test.empty());
    }

    public P67_7() {
        this.mainDeque = new ArrayDeque();
        this.helpDeque = new ArrayDeque();
    }

    public void push(int x) {
        helpDeque.addAll(mainDeque);
        mainDeque.clear();
        mainDeque.add(x);
        mainDeque.addAll(helpDeque);
        helpDeque.clear();
    }

    public int pop() {
        return mainDeque.removeFirst();
    }

    public int top() {
        return mainDeque.getFirst();
    }

    public boolean empty() {
        if (mainDeque.isEmpty()) {
            return true;
        }
        return false;
    }
}
