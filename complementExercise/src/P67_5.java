import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class P67_5 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(), help = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            while (!help.isEmpty() && top >= help.peek()) {
                stack.add(help.pop());
            }
            help.add(top);
        }
        for (Integer integer : help) {
            System.out.print(integer+" ");
        }
    }
}
