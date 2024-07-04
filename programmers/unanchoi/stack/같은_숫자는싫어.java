
import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        Stack stack = new Stack();
       for (int n: arr) {
           if (stack.isEmpty()) {
               stack.push(n);
           } else {
               if ((int)stack.peek() != n) {
                   stack.push(n);
               }
           }
       }
       answer = stack.stream().mapToInt(i -> (int)i).toArray();
        return answer;
    }
}