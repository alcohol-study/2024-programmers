import java.util.*;
class Solution {
    int answer = 0;
    Set<Integer> visited = new HashSet<>();

    public int solution(int n, int[][] computers) {
        answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, computers);
                answer++;
            }
        }
            
        return answer;
    }
    
    
    void dfs(int node, int[][] computers) {
        visited.add(node);

        for (int j = 0; j < computers.length; j++) {
            if (!visited.contains(j) && computers[node][j] == 1) {
                dfs(j, computers);
            }
        }
    }
}
