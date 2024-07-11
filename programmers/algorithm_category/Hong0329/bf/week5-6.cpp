//
// https://school.programmers.co.kr/learn/courses/30/lessons/86971
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;

int arr[104][104] = {0};
vector<bool> visited;

int dfs(int cur, int n) {
    if(visited[cur])
        return 0;
    int cnt = 1;

    visited[cur] = true;

    for(int i = 1; i <= n ; i++) {
        if(arr[cur][i]) {
            cnt += dfs(i,n);
        }
    }
    return cnt;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = 101;

    for(int i = 0 ; i < wires.size() ; i++) {
        arr[wires[i][0]][wires[i][1]] = 1;
        arr[wires[i][1]][wires[i][0]] = 1;
    }

    for(int j = 0 ; j < wires.size() ; j++) {
        arr[wires[j][0]][wires[j][1]] = arr[wires[j][1]][wires[j][0]] = 0;

        visited = vector<bool> (n + 1 , false);
        vector<int> divide;

        for(int k = 1 ; k <= n ; k++) {
            int key = dfs(k,n);
            if(!key)
                continue;
            divide.push_back(key);
        }
        answer = min(answer, abs(divide[0]-divide[1]));
        arr[wires[j][0]][wires[j][1]] = arr[wires[j][1]][wires[j][0]] = 1;
    }
    return answer;
}