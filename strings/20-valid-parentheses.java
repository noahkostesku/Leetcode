import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('{', '}');
        bracketMap.put('[', ']');

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (bracketMap.containsKey(ch)) {
                stack.push(ch);
            } 
            else {
                if (stack.isEmpty() || bracketMap.get(stack.pop()) != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
