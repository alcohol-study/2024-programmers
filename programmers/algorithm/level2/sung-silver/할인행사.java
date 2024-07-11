import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i <= discount.length - 10; i++) {
            map.clear();

            for (int j = i; j < i + 10; j++) {
                String item = discount[j];
                map.put(item, map.getOrDefault(item, 0) + 1);
            }
            
            if (checkCount(map, want, number)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean checkCount(HashMap<String, Integer> map, String[] want, int[] number) {
        for (int k = 0; k < want.length; k++) {
            if (map.getOrDefault(want[k], 0) != number[k]) {
                return false;
            }
        }
        return true;
    }
}

