import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        ArrayList<Integer> height = new ArrayList<>();
        ArrayList<Integer> width = new ArrayList<>();

        for(int[] com : sizes){
            if(com[0]>com[1]){
                height.add(com[0]);
                width.add(com[1]);
            }
            else{
                height.add(com[1]);
                width.add(com[0]);
            }
        }

        height.sort(Comparator.reverseOrder());
        width.sort(Comparator.reverseOrder());

        answer = height.get(0)*width.get(0);
        return answer;
    }
}
