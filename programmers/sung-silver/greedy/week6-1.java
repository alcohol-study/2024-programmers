class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n + 1];

        for (int i : reserve) {
            student[i] = 1;
        }

        for (int i : lost) {
            if (student[i] == 1) {
                student[i]--;
            } else {
                student[i] = -1;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (student[i] ==-1) {
                if (i != 1 && student[i - 1] == 1) {
                    student[i - 1] = 0;
                    student[i] = 0;
                } else if (i != n && student[i + 1] == 1) {
                    student[i + 1] = 0;
                    student[i] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(student[i]>=0){
                answer++;
            }
        }

        return answer;
    }
}
