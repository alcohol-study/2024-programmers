import java.util.*;
class Solution {
    public int solution(String word) {
            int answer = 0;
            int[] diff = {781,156,31,6,1};
            HashMap<String, Integer> map = new HashMap<>();
            map.put("A", 0);
            map.put("E", 1);
            map.put("I", 2);
            map.put("O", 3);
            map.put("U", 4);

            String[] wordArr = word.split("");
            answer += wordArr.length;

            int k=0;
            for(int i=0; i<wordArr.length; i++) {
                answer += diff[k++]*map.get(wordArr[i]);
            }        
            return answer;
        }
}
