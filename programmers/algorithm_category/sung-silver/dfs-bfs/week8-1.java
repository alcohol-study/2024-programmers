class Solution {
    int answer=0;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0,0,numbers,target);
        return answer;
    }
    
    void dfs(int sum, int location, int[] numbers, int target){
        if(location == numbers.length){
            if(sum == target){
                answer++;
            }
            return ;
        }
        dfs(sum+numbers[location], location+1, numbers, target);
        dfs(sum-numbers[location], location+1, numbers, target);
    }
}
