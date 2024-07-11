//
// https://school.programmers.co.kr/learn/courses/30/lessons/1843
//
#include <vector>
#include <string>
#include <algorithm>
using namespace std;


int solution(vector<string> arr)
{
    int answer = -1;
    int max_dp[102][102] = {0,};
    int min_dp[102][102] = {0,};
    int numSize = arr.size()/2+1;

    for(int i = 0; i < numSize; i++)
    {
        for(int j = 0; j < numSize; j++)
        {
            if(i == j)
            {
                max_dp[i][j] = stoi(arr[i*2]);
                min_dp[i][j] = stoi(arr[i*2]);
            }
            else
            {
                max_dp[i][j] = -10000000;
                min_dp[i][j] = 10000000;
            }
        }
    }

    for(int index = 1; index < numSize; index++)
    {
        for(int i = 0; i < numSize - index; i++)
        {
            int j = index + i;
            for(int k = i; k < j; k++)
            {
                if(arr[k * 2 + 1] == "-")
                {
                    max_dp[i][j] = max(max_dp[i][j], max_dp[i][k] - min_dp[k+1][j]);
                    min_dp[i][j] = min(min_dp[i][j], min_dp[i][k] - max_dp[k+1][j]);
                }
                else if(arr[k * 2 + 1] == "+")
                {
                    max_dp[i][j] = max(max_dp[i][j], max_dp[i][k] + max_dp[k+1][j]);
                    min_dp[i][j] = min(min_dp[i][j], min_dp[i][k] + min_dp[k+1][j]);
                }
            }
        }
    }

    answer = max_dp[0][numSize-1];
    return answer;
}