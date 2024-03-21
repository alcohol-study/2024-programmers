//import java.util.*;
//
//class Solution {
//    public int solution(int[] people, int limit) {
//        int answer = 0;
//        int sum = 0;
//
//        //오름차순 정렬
//        Arrays.sort(people);
//
//        for(int i = 0; i < people.length; i++){
//            sum += people[i];
//
//            if(sum > 100){
//                answer++;
//                sum = people[i];
//            }
//
//            if (sum < 100 && i == people.length-1 ){
//                answer++;
//            }
//
//        }
//
//        return answer;
//    }
//}