import java.util.*;

class Solution {

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char token : s.toCharArray()) {
            if (Objects.equals(token, '(')) {
                stack.push(token);
            }
            // token == RIGHT_LETTER
            else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    // stack안에 LEFT_LETTER가 있는 경우
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("()()"));
        System.out.println(solution.solution("(())()"));
        System.out.println(solution.solution(")()("));
        System.out.println(solution.solution("(()("));
    }
}