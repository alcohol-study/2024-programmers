class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        // dungeons를 탐색하여 가능한 갯수를 각각 구한다
        visited = new boolean[dungeons.length];
        dfs(0,k,dungeons);
        return answer;
    }

    private void dfs(int depth, int health, int[][] dungeons){
        for (int i = 0; i < dungeons.length; i++){
            if (visited[i] || dungeons[i][0] > health) {
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, health - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        answer = Math.max(answer, depth);
    }
}
