//
// https://school.programmers.co.kr/learn/courses/30/lessons/42748
//
#include <string>
#include <vector>
#include <queue>
#include <iostream>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    int a, b, c;

    for(int i = 0 ; i < commands.size() ; i++)
    {
        vector<int>v;
        a = commands[i][0]-1;
        b = commands[i][1]-1;
        c = commands[i][2]-1;
        for(int j = a; j<=b; j++){
            v.push_back(array[j]);
        }
        sort(v.begin(),v.end());
        answer.push_back(v[c]);
    }
    return answer;
}