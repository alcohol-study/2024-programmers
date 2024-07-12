//
// Created by hong jun chung on 7/12/24.
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> m;

    for(int i = 0 ; i < clothes.size() ; i++)
        m[clothes[i][1]] += 1;

    for(auto wear:m)
        answer *= (wear.second + 1);

    return answer-1;
}