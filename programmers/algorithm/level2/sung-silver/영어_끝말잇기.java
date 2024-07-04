import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> set = new HashSet<String>();
        int idx = 1;

        set.add(words[0]);

        while(idx < words.length){
            if(set.contains(words[idx]) || words[idx-1].charAt(words[idx-1].length() - 1)!=words[idx].charAt(0)){
                answer[0] = idx%n+1;
                answer[1] = idx/n+1;
                return answer;
            }
            set.add(words[idx]);
            idx++;
        }

        return answer;
    }
}
