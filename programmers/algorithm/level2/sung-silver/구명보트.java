import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int front = 0;
        int end = people.length-1;
        Arrays.sort(people);
        while(front<=end){
            if(people[front]+people[end]<=limit){
                answer++;
                front++;
                end--;
            }
            else{
                answer++;
                end--;
            }
        }

        return answer;
    }
}
