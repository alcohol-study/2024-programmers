package programmers.hellozo0.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
    import java.lang.Math;
import java.util.*;

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            List<Integer> answer = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();

            for(int i = 0; i < speeds.length; i++){ //7 3, 9 이렇게 들어갈거임
                q.add((int)(Math.ceil((100.0 - progresses[i]) / speeds[i])));
            }

            while (!q.isEmpty()){
                int test = q.poll(); //7의 값 -> 3 -> 9
                // int next = q.peek(); //3의 값 -> 9 -> 없음
                int count = 1;

                while(!q.isEmpty() && test >= q.peek()){
                    count++;
                    q.poll();
                    // next = q.peek();
                }
                answer.add(count); //test = 9일 경우, next 가 없어서 1이 바로 들어옴
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
