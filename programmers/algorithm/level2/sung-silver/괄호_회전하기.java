import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int x = s.length();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<x; i++){
            String spin = s.substring(i)+s.substring(0,i);
            if(checkTrue(spin)) answer++;
        }

        return answer;
    }

    private boolean checkTrue(String s){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            }
            else{
                if(st.isEmpty()) return false;
                if(s.charAt(i) == ')' && st.peek() == '(') st.pop();
                else if(s.charAt(i) == '}' && st.peek() == '{') st.pop();
                else if(s.charAt(i) == ']' && st.peek() == '[') st.pop();
                else return false;
            }
        }
        return st.isEmpty();
    }
}
