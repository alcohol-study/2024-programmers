//
// https://school.programmers.co.kr/learn/courses/30/lessons/86491
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    int w = 0;
    int h=0;
    int cnt = sizes.size();

    for(int i = 0 ; i < cnt;i++){
        h = max(h,(max(sizes[i][0], sizes[i][1])));
        w = max(w,(min(sizes[i][0], sizes[i][1])));
    }
    answer = h*w;
    return answer;
}