import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int number = 0;
        
        for(int i=0;i<elements.length;i++){
            number = 0;
            for(int j=0;j<elements.length;j++){
                if(i+j>=elements.length){
                    number += elements[(i+j)%elements.length];
                    set.add(number);
                }
                else{
                    number += elements[i+j];
                    set.add(number);
                }
            }
        }
        
        answer = set.size();
        
        return answer;
    }
}
