import java.util.*;
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int com = 0;
        while(st.hasMoreTokens()){
            com = Integer.parseInt(st.nextToken());
            if(com<min){
                min = com;
            }
            if(com>max){
                max = com;
            }
        }
        return min + " " + max;
    }
}
