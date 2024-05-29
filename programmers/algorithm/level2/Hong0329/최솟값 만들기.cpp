//
// https://school.programmers.co.kr/learn/courses/30/lessons/12941?language=cpp
//
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> A, vector<int> B)
{
    int answer = 0;

    sort(A.begin(), A.end());
    sort(B.begin(), B.end());

    for(int i = 0 ; i < A.size() ; i++) {
        int y = A.size() - i - 1;
        answer += A[i] * B[y];
    }

    return answer;
}