import java.util.ArrayDeque;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }

    public boolean isValid(String s) {
        if (s.length() == 1 || s.length() == 0 || ((s.length() & 1) != 0)) {
            return false;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        if (chars[0] == ')' || chars[0] == '}' || chars[0] == ']') {
            return false;
        }
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '{' || aChar == '[') {
                stack.addFirst(aChar);
                continue;
            }

            if (!stack.isEmpty()) {
                Character pollFirst = stack.pollFirst();
                if (aChar == ')') {
                    if (pollFirst != '(') {
                        return false;
                    }
                }
                if (aChar == '}') {
                    if (pollFirst != '{') {
                        return false;
                    }
                }
                if (aChar == ']') {
                    if (pollFirst != '[') {
                        return false;
                    }
                }
            } else {
                return false;
            }

        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
