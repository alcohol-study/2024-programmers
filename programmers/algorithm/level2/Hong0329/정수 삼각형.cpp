//
// Created by hong jun chung on 7/28/24.
//
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> t) {
    int answer = 0;

    for (int i = t.size() - 1; i > 0 ; i--) {
        for (int j = 0; j < t[i].size() - 1; j++)
            t[i - 1][j] += max(t[i][j], t[i][j + 1]);
    }
    answer = t[0][0];
    return answer;
}