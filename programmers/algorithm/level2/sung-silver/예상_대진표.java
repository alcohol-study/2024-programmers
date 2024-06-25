class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int A = a;
        int B = b;

        while (A != B){
            A = (A + 1) / 2;
            B = (B + 1) / 2;
            answer++;
        }

        return answer;
    }
}
