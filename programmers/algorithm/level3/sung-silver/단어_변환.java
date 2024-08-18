import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        Set<String> wordSet = new HashSet<>();

        for(String word : words){
            wordSet.add(word);
        }

        if(!wordSet.contains(target)){
            return 0;
        }

        dfs(begin, target, 1, wordSet, 1, answer);

        return answer;
    }

    private void dfs(String compare, String target, int idx, Set<String> wordSet, int count, int answer){
        System.out.println(compare);
        if(compare.equals(target)){
            answer = Math.min(count, answer);
            return ;
        }

        for(char i ='a' ; i<'z' ;i++ ){
            String newCompare = compare.substring(0, idx-1) + i + compare.substring(idx+1, compare.length());
            if(wordSet.contains(newCompare)){
                dfs(newCompare, target, idx+1, wordSet, count+1, answer);
            }
        }
    }
}
