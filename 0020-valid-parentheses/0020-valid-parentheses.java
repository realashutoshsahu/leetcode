import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Step 1: If opening bracket → push
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // Step 2: If closing bracket
            else {
                // If stack empty → invalid
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Step 3: Check matching
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Step 4: Stack should be empty
        return stack.isEmpty();
    }
}