public class Solution {
    public int solution(int n) {
        int batteryUsage = 0;
      
        while (n > 0) {

            if (n % 2 == 1) {
                batteryUsage++;
                n--;  
            }
            n /= 2;
        }

        return batteryUsage;
    }
}
