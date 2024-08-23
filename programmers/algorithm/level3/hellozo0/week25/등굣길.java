package programmers.algorithm.level3.hellozo0.week25;

public class 등굣길 {
    import java.util.*;

    class Solution {

        public int solution(int m, int n, int[][] puddles) {

            int[][] maps = new int[n+1][m+1];
            final int mod = 1000000007;

            for(int i = 0; i < puddles.length; i++) {
                maps[puddles[i][1]][puddles[i][0]] = -1;
            }

            maps[1][1] = 1;

            for(int i = 1; i <=n; i++){
                for(int j = 1; j <=m; j++){
                    if(maps[i][j] == -1) continue;

                    if(maps[i-1][j] > 0) {
                        maps[i][j] += maps[i-1][j] % mod;
                    }

                    if(maps[i][j-1] > 0){
                        maps[i][j] += maps[i][j-1] % mod;
                    }

                }
            }

            return maps[n][m] % mod;

        }
    }
}


//--> DFS로 푸니까 런타임 에러
//import java.util.*;
//
//class Solution {
//
//    static int answer;
//    static int[] dx = {1,0};
//    static int[] dy = {0,1};
//
//    public int solution(int m, int n, int[][] puddles) {
//
//        int[][] maps = new int[n+1][m+1];
//        boolean[][] visited = new boolean[n+1][m+1];
//        answer = 0;
//
//        for(int i = 0; i < puddles.length; i++){
//            int x = puddles[i][0];
//            int y = puddles[i][1];
//
//            maps[x][y] = Integer.MAX_VALUE;
//        }
//
//        dfs(maps, visited,n,m);
//
//        return answer % 1000000007;
//    }
//
//    private static void dfs(int[][] maps, boolean[][] visited, int n, int m) {
//        Stack<int[]> stack = new Stack<>();
//        visited[1][1] = true;
//        stack.push(new int[]{1,1});
//
//        while(!stack.isEmpty()){
//            int[] now = stack.pop();
//
//            for(int i = 0; i <2; i++){
//                int nowX = now[0] + dx[i];
//                int nowY = now[1] + dy[i];
//
//                if(nowX >= 1 && nowY >= 1 && nowX <= n && nowY <= m && !visited[nowX][nowY] && maps[nowX][nowY] == 0){
//                    visited[nowX][nowY] = true;
//                    maps[nowX][nowY] = maps[now[0]][now[1]] + 1;
//                    // System.out.println("x : " + nowX + "  y : " + nowY + "   maps[x][y] : " + maps[nowX][nowY]);
//                    stack.push(new int[] {nowX,nowY});
//                }
//
//                // if(nowX == n && nowY == m) return;
//            }
//
//            answer = maps[n][m]-1;
//
//        }
//
//
//    }
//
//}