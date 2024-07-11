//
// https://school.programmers.co.kr/learn/courses/30/lessons/42627
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;
struct cmp {
    bool operator()(vector<int> a, vector<int> b) {
        return a[1] > b[1];
    }
};

int solution(vector<vector<int>> jobs) {
    int answer = 0;
    int time = 0;
    int cnt =0;
    int current =0;
    priority_queue<vector<int>, vector<vector<int>>,cmp> pq;
    sort(jobs.begin(), jobs.end());

    while(cnt<jobs.size() || !pq.empty()) {
        if(cnt<jobs.size() && jobs[cnt][0] <= current) {
            pq.push(jobs[cnt]);
            cnt++;
            continue;
        }
        if(!pq.empty()) {
            current += pq.top()[1];
            time += current - pq.top()[0];
            pq.pop();
        }
        else {
            current = jobs[cnt][0];
        }
    }
    answer = time/jobs.size();
    return answer;
}