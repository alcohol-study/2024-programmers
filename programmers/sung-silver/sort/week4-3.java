import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int h=0;
        int count = 0;
        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++){
            h = citations[i];
            count = 0;
            for(int j=i; j<citations.length; j++){
                if(h <= citations[j]){
                    count++;
                }
            }
            if(h <= count){
                answer = h;
            }
            if(count < h){
                answer = count;
                break;
            }
        }
        return answer;
    }
}
