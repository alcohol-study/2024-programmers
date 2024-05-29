import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        answer += Character.toUpperCase(s.charAt(0));
        for(int i=1; i<s.length() ; i++){
            char c = s.charAt(i);
            if(s.charAt(i-1)==' '){
                answer+= Character.toUpperCase(c);
            }
            else{
                answer+= Character.toLowerCase(c);
            }
        }
        System.out.println(answer);
        return answer;
    }
}
