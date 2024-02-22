import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        Stack<Character> stack = new Stack<>();
        if(s.charAt(0)==')'){
            answer = false;
            return answer;
        }

        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            stack.push(c);
        }

        while(!stack.isEmpty()){
            if(stack.peek()=='('){
                count++;
                stack.pop();
            }
            else if(count>=0&&stack.peek()==')'){
                stack.pop();
                count--;
            }
            else{
                answer = false;
                break;
            }
        }

        if(count!=0){
            answer = false;
        }

        return answer;
    }
}
