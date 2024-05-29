package programmers.algorithm.level2.hellozo0.week13;

public class 이진_변환_반복하기 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];

            while(s.length() > 1) {

                int one = 0;
                for(int i=0; i<s.length(); i++) {

                    if(s.charAt(i) == '0') answer[1]++;
                    else one++;
                }

                s = Integer.toBinaryString(one);
                answer[0]++;
            }

            return answer;
        }
    }
}
