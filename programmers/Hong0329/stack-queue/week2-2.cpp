//
// https://school.programmers.co.kr/learn/courses/30/lessons/42586
//
#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    queue<int> que;
    int cnt;

    for(int i=0;i<progresses.size();i++) {
        que.push(i);
    }

    while(!que.empty()) {
        cnt = 0;
        for(int i = 0; i < progresses.size() ; i++) {
            if(progresses[i]<100)
                progresses[i] += speeds[i];
        }
        while(!que.empty() && progresses[que.front()] >= 100) {
            cnt += 1;
            que.pop();
        }

        if(cnt){
            answer.push_back(cnt);
        }
    }
    return answer;
}