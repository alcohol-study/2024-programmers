package programmers.algorithm.level2.hellozo0.week20;

public class 캐시_정답버전 {
    import java.util.*;

    class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            ArrayList<String> list = new ArrayList<>();

            if(cacheSize == 0){
                return cities.length * 5;
            }

            for(int i = 0; i < cities.length; i++){

                String city = cities[i].toUpperCase();

                if( list.contains(city) ){
                    list.remove(city);
                    list.add(city);
                    answer += 1;
                } else {
                    // 찼으면 제거
                    if(list.size() == cacheSize){
                        list.remove(0);
                    }
                    // 그 후 추가
                    list.add(city);
                    answer += 5;
                }
            }


            return answer;
        }
    }

}
