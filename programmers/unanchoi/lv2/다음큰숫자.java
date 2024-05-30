public class Solution {
    public static int solution(int n) {
        int tmp = n;
        while (true) {
            n += 1;
            if (Integer.bitCount(tmp) == Integer.bitCount(n)) {
                tmp = n;
                break;
            }
        }
        return tmp;
    }


}
