package programmers.algorithm.level3.hellozo0.week23;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
    import java.util.*;

    class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int work : works) {
                pq.add(work);
            }

            for(int i = 0; i < n; i++) {
                int num = pq.poll();
                pq.add(num-1);
            }

            if( pq.peek() <= 0) {
                return 0;
            }

            while(!pq.isEmpty()){
                answer += Math.pow(pq.poll(),2);
            }

            return answer;
        }
    }
}
