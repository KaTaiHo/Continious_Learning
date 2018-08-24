import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if (c == '{' || c == '[' || c == '(')
            {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) return false;
                char removed = stack.pop();
                if (c == '}' && removed != '{') return false;
                if (c == ']' && removed != '[') return false;
                if (c == ')' && removed != '(') return false; 
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("[[]]]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("()"));
    }
}