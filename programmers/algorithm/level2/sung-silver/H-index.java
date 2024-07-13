import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        for(int i=1;i<n+1;i++){
            if(citations[n-i]>=i){
                answer = i; // H-index 후보값 i보다 크거나 같은 인용 횟수를 가진 논문이 적어도 i편 있음
            }
        }
        return answer;
    }
}
