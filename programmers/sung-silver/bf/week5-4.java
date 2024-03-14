class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int b = 0;
        int y = 0;
        int S = brown+yellow;
        for(int width = S-1;width>0;width--){
            int height = S/width;
            y = (height-2)*(width-2);
            b = S-y;
            if(yellow==y&&brown==b){
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }

        return answer;
    }
}
