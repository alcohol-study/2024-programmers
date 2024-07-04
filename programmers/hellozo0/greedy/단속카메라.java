import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        //배열 안에 있는 요소 정렬( 나간시점 )
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        //-15
        int min = -30000;
        for(int i = 0; i < routes.length; i++){
            if(min < routes[i][0]){
                answer++;
                min = routes[i][1];
            }
        }


        return answer;
    }
}  