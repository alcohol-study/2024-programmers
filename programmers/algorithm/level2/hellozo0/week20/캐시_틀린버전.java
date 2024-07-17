package programmers.algorithm.level2.hellozo0.week20;

import java.util.LinkedList;
import java.util.Queue;

public class 캐시_틀린버전 {
    import java.util.*;
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;

            Queue<String> queue = new LinkedList<>();

            if(cacheSize == 0 ) {
                return cities.length * 5;
            }

            //1. 기본 세팅
            for(int i = 0; i < cacheSize; i++) {
                queue.add(cities[i].toLowerCase());
                answer += 5;
            }

            for(int i = cacheSize; i < cities.length; i++) {

                String city = cities[i].toLowerCase();  //이번꺼부터
                boolean flag = true;

                for(int j = 0; j < cacheSize; j++){
                    // System.out.println("#1");

                    String inCache = queue.poll(); //jeju
                    if(inCache.equals(city)) {
                        // System.out.println("#2");
                        answer += 1;
                        flag = false;

                    }
                    // System.out.println("--- " + inCache + "--- city : " + city);
                    queue.add(inCache); //jeju , pangyo
                }


                //여기서 순서 정리
                if(flag) {
                    // System.out.println("#3");
                    answer += 5;
                    queue.poll();
                    queue.add(city);
                }
                else {
                    // System.out.println("#4");
                    queue.poll();
                    queue.add(city);
                }

            }

            return answer;
        }
    }

}
