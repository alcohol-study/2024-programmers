package programmers.algorithm.level2.hellozo0.week16;

public class 멀리뛰기 {
    class Solution {
        public long solution(int n) {

            long[] dp = new long[n+2];
            dp[1] = 1;
            dp[2] = 2;

            if(n < 3) return dp[n];

            for(int i = 3; i <=n; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
            }

            return dp[n];

            // long answer = 1;
            //2를 0개, 1개, 2개 2xi <=
            // int i = 1;
            // while(2 * i <= n){
            //     answer += (n - (2 * i) + 1) % 1234567;
            //     i++;
            // }

        }
    }
}
