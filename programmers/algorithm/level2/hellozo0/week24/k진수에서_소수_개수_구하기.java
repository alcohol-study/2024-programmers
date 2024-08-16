package programmers.algorithm.level2.hellozo0.week24;

public class k진수에서_소수_개수_구하기 {
    class Solution {
        public int solution(int n, int k) {
            int answer = 0;

            String letter = Integer.toString(n,k);
            String[] letters = letter.split("0");

            for( String a : letters) {
                if(a.equals("")) continue;
                if(isPrime(Long.parseLong(a)) ) answer++;
            }

            return answer;
        }

        public boolean isPrime(Long num) {
            if(num == 0 || num == 1) return false;

            for(int i = 2; i <= (int) Math.sqrt(num); i++) {
                if( num % i == 0) return false;
            }

            return true;
        }
    }

}


//틀린 버전 - 런타임 에러
//class Solution {
//    public int solution(int n, int k) {
//        int answer = 0;
//
//        String letter = Integer.toString(n,k);
//        //211 0 2 01010 11
//
//        StringBuilder sb = new StringBuilder();
//
//        System.out.println(letter);
//        for(int i = 0; i< letter.length(); i++){
//            char c = letter.charAt(i);
//
//
//            if(c == '0') {
//                // System.out.println(sb.toString());
//                String s = sb.toString();
//                if(s.equals("")) continue;
//                if(isPrime(Integer.parseInt(s))) answer++;
//                sb = new StringBuilder();
//            }
//            else {sb.append(c);}
//        }
//
//        //마지막
//        String s = sb.toString();
//        if(isPrime(Integer.parseInt(s))) answer++;
//
//        return answer;
//    }
//
//    public boolean isPrime(int num) {
//        if(num == 0 || num == 1) return false;
//
//        for(int i = 2; i <= (int) Math.sqrt(num); i++) {
//            if( num % i == 0) return false;
//        }
//
//        return true;
//    }
//}
//