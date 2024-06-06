//
// Created by hong jun chung on 6/6/24.
//
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
 
int fun(int a , int b)
{
    int A = max(a, b);
    int B = min(a, b);
    
    while(A % B != 0)
    {
        int R = A % B;
        A = B;
        B = R;
    }
    return B;
}
 

int solution(vector<int> arr) 
{
    int answer = arr[0];
    for(int i = 1; i < arr.size(); i++)
    {
        int x = fun(answer, arr[i]);
        int y = answer * arr[i] / x;
        answer = y;
    }
    return answer;
}