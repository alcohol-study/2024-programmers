//
// Created by hong jun chung on 7/21/24.
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    int cnt = 0;

    priority_queue<int> pq;
    priority_queue<int, vector<int>, greater<int>> pq2;
    for(auto o:operations) {
        string s = o.substr(0,1);
        int n = atoi(o.substr(2).c_str());
        if(cnt == 0){
            while(!pq.empty()) pq.pop();
            while(!pq2.empty()) pq2.pop();
        }
        if(s == "I"){
            pq.push(n);
            pq2.push(n);
            cnt++;
        }
        else {
            if(n == 1 && cnt!=0) {
                pq.pop();
                cnt--;
            }
            else if(n==-1 && cnt!=0) {
                pq2.pop();
                cnt--;
            }
        }
    }
    if(cnt == 0){
        answer.push_back(0);
        answer.push_back(0);

    }else {
        answer.push_back(pq.top());
        answer.push_back(pq2.top());
    }
    return answer;
}