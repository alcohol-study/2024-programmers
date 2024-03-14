import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        makePermutation("",numbers, set);
        for(int i : set){
            if(i!=0&&i!=1&&isPrime(i)){
                answer++;
            }
        }
        return answer;
    }

    public boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    private void makePermutation(String perm, String others, Set<Integer> set){
        if(!perm.isEmpty()){
            set.add(Integer.parseInt(perm));
        }
        for(int i=0;i<others.length();i++){
            String remain = others.substring(0,i)+others.substring(i+1);
            makePermutation(perm+others.charAt(i),remain,set);
        }
    }
}
