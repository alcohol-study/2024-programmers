//
// Created by hong jun chung on 7/28/24.
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;

    sort(dungeons.begin(), dungeons.end());

    do{
        int num = k;
        int cnt = 0;

        for(int i = 0; i< dungeons.size(); i++) {
            if(dungeons[i][0] <= num) {
                num -= dungeons[i][1];
                cnt++;
            }
        }

        answer = max(answer, cnt);
    } while(next_permutation(dungeons.begin(), dungeons.end()));
    return answer;
}