import java.util.*;

class Solution {
    public int solution(int[] citations) {   
        
        int answer = 0;        
//         Integer[] newArray= Arrays.stream(citations).boxed().toArray(Integer[]::new);
        
//         Arrays.sort(newArray, Collections.reverseOrder()); 
        
        Arrays.sort(citations);
        //0 1 2 3 4
        //0 1 3 5 6
        
        //0 1 4 5 6 --> 정답은 3임
        //최대값이여야해서 위에서 부터 인덱스 접근해야함
        
        // 0 2 2 3 4 6 7 9 / 길이는 8
        
        for(int i = 0; i < citations.length; i++){
            int count = citations.length - i;
            if( citations[i] >= count){ 
                answer = count;
                break;
            }
        }

        return answer;
    }
}
