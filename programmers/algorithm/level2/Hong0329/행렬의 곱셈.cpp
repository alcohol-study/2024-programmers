//
// Created by hong jun chung on 7/12/24.
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    vector<vector<int>> answer;

    for(int i = 0 ; i < arr1.size() ; i++) {
        vector<int>arr3;
        for(int j = 0 ; j < arr2[0].size() ; j++) {
            int cnt = 0;
            for(int k = 0 ; k < arr1[1].size() ; k++){
                cnt += arr1[i][k] * arr2[k][j];
            }
            arr3.push_back(cnt);
        }
        answer.push_back(arr3);
    }
    return answer;
}