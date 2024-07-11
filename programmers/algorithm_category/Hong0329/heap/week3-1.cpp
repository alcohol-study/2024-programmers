//
// https://school.programmers.co.kr/learn/courses/30/lessons/42626
//
#include <string>
#include <vector>
#include <iostream>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>,greater<int>> pq(scoville.begin(), scoville.end());

    while(pq.size()>1) {
        int a = pq.top();
        if(a>=K)
            break;
        pq.pop();
        int b = pq.top();
        pq.pop();
        pq.push(a + (b*2));
        answer++;
    }
    if(pq.top()<K)
        return -1;
    return answer;
}