package programmers.algorithm.level2.hellozo0.week25;

public class 압축 {
    import java.util.*;

    class Solution {
        public int[] solution(String msg) {
            ArrayList<Integer> answer = new ArrayList<>();
            HashMap<String,Integer> map = new HashMap<>();

            String first = msg.substring(0,1);
            int count = 27;

            for(int i = 1; i < msg.length(); i++){

                String second = msg.substring(i,i+1);
                String temp = first+second;

                if(map.containsKey(temp)){
                    first = temp;
                    continue;
                }

                //이부분 반복 --> 나중에 함수 빼도 될듯 ~ 그치만 지금은 귀찮으니까~
                if(first.length() == 1) {
                    char a = first.charAt(0);
                    answer.add(a-'A'+1);
                } else {
                    answer.add(map.get(first));
                }
                //이부분 반복 --> 나중에 함수 빼도 될듯 ~ 그치만 지금은 귀찮으니까~

                map.put(temp,count++);
                first = second;

            }

            //이부분 반복 --> 나중에 함수 빼도 될듯 ~ 그치만 지금은 귀찮으니까~
            if(first.length() == 1) {
                char a = first.charAt(0);
                answer.add(a-'A'+1);
            } else {
                answer.add(map.get(first));
            }
            //이부분 반복 --> 나중에 함수 빼도 될듯 ~ 그치만 지금은 귀찮으니까~

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }

    }
}
