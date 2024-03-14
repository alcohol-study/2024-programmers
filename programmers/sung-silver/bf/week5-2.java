import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int[] score = {0,0,0};

        for(int i=0;i<answers.length;i++){
            if(answers[i]==one[i%one.length]) score[0]++;
            if(answers[i]==two[i%two.length]) score[1]++;
            if(answers[i]==three[i%three.length]) score[2]++;
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> answerList = new ArrayList<>();
        for(int i=0; i<score.length; i++) if(max == score[i]) answerList.add(i+1);

        answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
