//
// https://school.programmers.co.kr/learn/courses/30/lessons/42884
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 1;

    sort(routes.begin(), routes.end());

    int key = routes[0][1];

    for(int i =1; i<routes.size(); i++) {
        if(key < routes[i][0]) {
            answer++;
            key = routes[i][1];
        }
        if(routes[i][1] <= key) {
            key = routes[i][1];
        }
    }
    return answer;
}