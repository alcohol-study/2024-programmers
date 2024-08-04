//
// Created by hong jun chung on 8/4/24.
//
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>
using namespace std;

bool compare(const pair<int, int> &a, const pair<int, int> &b) {
    if(a.first == b.first)
        return a.second < b.second;
    return a.first > b.first;
}

int solution(vector<int> priorities, int location) {
    int answer = 0;
    int key = 0;
    int cnt = 0;
    vector<pair<int,int>>vec;
    queue<pair<int,int>>que;

    for(int i =0 ;i<priorities.size();i++){
        vec.push_back(make_pair(priorities[i],i));
        que.push(make_pair(priorities[i],i));
    }

    sort(vec.begin(),vec.end(),compare);

    while(!que.empty()) {
        while(vec[key].first!=que.front().first && vec[key].second!=que.front().second) {
            // cout<<"["<<que.front().first<<","<<que.front().second<<"]";
            que.push(que.front());
            que.pop();
        }
        cnt++;
        key++;
        if(que.front().second == location){
            // cout<<que.front().second<<que.front().second<<location;
            answer = cnt;
            break;
        }
        que.pop();
    }
    return answer;
}