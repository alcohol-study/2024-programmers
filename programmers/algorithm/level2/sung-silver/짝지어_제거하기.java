import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){
           if(stack.isEmpty()){
              stack.push(s.charAt(i));
           }
           else{
              if(stack.peek() == s.charAt(i)){
                 stack.pop();
              }
              else{
                 stack.push(s.charAt(i));
              }
            }
        }
        
        while(!stack.isEmpty()){
           sb.append(stack.pop());
        }
        
        if(sb.length() == 0){
           answer = 1;
        }
        else{
            answer = 0;
        }
        
        return answer;
    }
    
}
