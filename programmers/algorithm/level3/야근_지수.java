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
