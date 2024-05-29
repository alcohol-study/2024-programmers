package programmers.algorithm.level2.hellozo0.week14;

import java.util.Stack;

public class 짝지어_제거하기 {
    import java.util.*;

    class Solution
    {
        public int solution(String s)
        {
            int answer = -1;

            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < s.length(); i++){
                char alphabet = s.charAt(i);

                if(stack.isEmpty()) {
                    stack.push(alphabet);
                } else {
                    if(stack.peek() == alphabet) {
                        stack.pop();
                    } else {
                        stack.push(alphabet);
                    }
                }
            }

            if( stack.isEmpty()) answer = 1;
            else answer = 0;


            return answer;
        }
    }
}

//틀린 노가다 방법
//class Solution
//{
//    public int solution(String s)
//    {
//        int answer = -1;
//        StringBuilder sb = new StringBuilder();
//        boolean flag = true;
//        int count = 0;
//
//        while(count != s.length()-1){
//            for(int i = 0; i < s.length()-1; i++){
//                if(s.charAt(i) == s.charAt(i+1)){
//                    i = i+2;
//                    flag = true;
//                } else {
//                    sb.append(s.charAt(i));
//                    flag = false;
//                    count++;
//                }
//            }
//            if(!flag) sb.append(s.charAt(s.length()-1));
//            s = sb.toString();
//        }
//
//        if(s.length() == 0) answer = 1;
//        else answer = 0;
//
//        return answer;
//    }
//}