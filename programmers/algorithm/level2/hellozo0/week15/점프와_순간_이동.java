package programmers.algorithm.level2.hellozo0.week15;

public class 점프와_순간_이동 {
    import java.util.*;

    public class Solution {
        public int solution(int n) {
            int ans = 0;

            while (n > 0) {
                if (n % 2 == 1) {
                    ans += 1;
                }
                n /= 2;
            }

            return ans;
        }
    }
}
