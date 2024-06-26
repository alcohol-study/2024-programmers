import java.util.*;
import java.util.stream.Collectors;

class Solution {
     public int solution(int k, int[] tangerine) {
        int answer = 1;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<tangerine.length;i++){
            if(map.get(tangerine[i])==null)
                map.put(tangerine[i], 1);
            else
                map.put(tangerine[i], map.get(tangerine[i])+1);
        }

        for (Integer key : map.keySet().stream()
                .sorted(Comparator.comparing(map::get).reversed())
                .collect(Collectors.toList())){
            count += map.get(key);
            if(count>=k){
                break;
            }
            answer += 1;
        }

        return answer;
    }
}
