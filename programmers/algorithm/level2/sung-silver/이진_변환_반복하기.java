class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int removeZero = 0;
        int transformCount = 0;
        
        while (!s.equals("1")) {
            transformCount++;
            int length = s.length();
            s = s.replaceAll("0", "");
            removeZero += length - s.length();
            s = Integer.toBinaryString(s.length());
        }
        
        answer = new int[]{transformCount, removeZero};
        
        return answer;
    }
}
