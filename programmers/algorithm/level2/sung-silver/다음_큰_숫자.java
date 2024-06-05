class Solution {
    public int solution(int n) {
        int answer = 0;
        String nBinary = Integer.toBinaryString(n);
        int nOneCount = getOneCount(nBinary);
        
        for(int i = n+1;;i++){
            String comBinary = Integer.toBinaryString(i);
            int comOneCount = getOneCount(comBinary);
            if(nOneCount == comOneCount){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    private int getOneCount(String str){
        int OneCount = 0;
        for(int i=0; i<str.length();i++){
            char c = str.charAt(i);
            if(c=='1'){
                OneCount++;
            }
        }
        return OneCount;
    }
}
