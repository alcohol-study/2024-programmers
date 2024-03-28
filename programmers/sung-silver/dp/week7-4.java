class Solution {
    public static int solution(int[] money) {
        int answer = 0;
        int len = money.length;
        
	int[] case1 = new int[len];
        int[] case2 = new int[len];
        
	case1[0] = money[0];
        case1[1] = money[0];
        
	case2[0] = 0;
        case2[1] = money[1];
        
	for(int i=2; i<len; i++){
            case1[i] = Math.max(case1[i-2] + money[i], case1[i-1]);
            case2[i] = Math.max(case2[i-2] + money[i], case2[i-1]);
        }
        answer = Math.max(case1[len-2], case2[len-1]);

        return answer;
    }
}
