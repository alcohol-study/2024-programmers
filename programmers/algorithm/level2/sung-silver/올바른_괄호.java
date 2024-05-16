import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char compare = ' ';
        for(int i=0; i<s.length(); i++){
            compare = s.charAt(i);
            if(compare == '('){
                stack.push(compare);
            }
            else if(compare == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
