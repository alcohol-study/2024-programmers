class Solution {
    int answer = 0;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        
        if(!contains(words, target)){
            return 0;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (canChange(begin, words[i])) {
                visited = new boolean[words.length];
                visited[i] = true;
                dfs(1, target, words[i], words);
            }
        }
        
        return answer;
    }
    
    private boolean contains(String[] words, String target){
        for(String word : words){
            if(word.equals(target)){
                return true;
            }
        }
        return false;
    }
    
    private void dfs(int idx, String target, String current, String[] words){
        if(target.equals(current)){
            answer = Math.min(idx, answer);
            return ;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canChange(current, words[i])) {
                visited[i] = true;
                dfs(idx + 1, target, words[i], words);
                visited[i] = false;
            }
        }
    }
    
    private static boolean canChange(String begin, String target) {
        int notEqualSize = 0;

        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                notEqualSize++;
            }
        }
        
        if(notEqualSize==1){
            return true;
        }

        return false;
    }
}
