package programmers.hellozo0.stack_queue;

import java.util.Arrays;

public class 같은_숫자는_싫어 {
    public int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        answer[0] = arr[0];
        int count = 0;

        //배열을 순서대로 새로운 answer에 넣고, 만약 같으면 넣지 말고
        for(int i = 1; i < arr.length; i++){
            if(answer[count] != arr[i]){
                count++;
                answer[count] = arr[i];
            }
        }

        //남은 배열의 0을 없애기, 배열 복사
        int[] answer2 = Arrays.copyOf(answer, count+1);

        return answer2;
    }
}
