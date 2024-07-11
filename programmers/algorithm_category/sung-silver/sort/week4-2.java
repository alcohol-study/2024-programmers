import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder stb = new StringBuilder();
        String[] vals = new String[numbers.length];
        for(int i=0;i< numbers.length;i++){
            vals[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(vals, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        for(String val : vals){
            answer += val;
        }

        if(answer.charAt(0) == '0'){
            return String.valueOf(0);
        }

        return answer;
    }
}
