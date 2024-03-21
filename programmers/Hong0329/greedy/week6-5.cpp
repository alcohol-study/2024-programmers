//
// https://school.programmers.co.kr/learn/courses/30/lessons/42861
//
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

bool compare(vector<int> a, vector<int> b){
    return a[2] < b[2];
}

int parent(int idx, vector<int> nodes){
    if(nodes[idx] == idx)
        return idx;
    return nodes[idx] = parent(nodes[idx],nodes);
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    vector<int> nodes(n,0);

    sort(costs.begin(),costs.end(),compare);

    for(int i = 0; i < n;i++){
        nodes[i] = i;
    }

    for(int i = 0; i < costs.size();i++) {
        int cost = costs[i][2];

        if(parent(costs[i][0],nodes) != parent(costs[i][1],nodes)) {
            answer+= cost;
            nodes[parent(costs[i][1],nodes)] = parent(costs[i][0],nodes);
        }
    }
    return answer;
}