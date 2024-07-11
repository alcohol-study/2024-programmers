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
    vector<int> garo;
    vector<int> sero;
    int cnt = sizes.size();

    for(int i = 0 ; i < cnt;i++){
        garo.push_back(max(sizes[i][0], sizes[i][1]));
        sero.push_back(min(sizes[i][0], sizes[i][1]));
    }
    sort(garo.begin(), garo.end());
    sort(sero.begin(), sero.end());
    answer = garo[cnt - 1] * sero[cnt - 1];
    return answer;
}