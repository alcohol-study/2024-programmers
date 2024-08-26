import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] diff = {781, 156, 31, 6, 1};
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);
        
        answer += word.length(); // 모든 문자열의 구성이 A라면 처리됨
        
        int k=0;
        for(int i=0;i<word.length();i++){
            answer += diff[k++]*map.get(word.charAt(i));
        }
        
        return answer;
    }
}
