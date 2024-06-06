//
// Created by hong jun chung on 6/6/24.
//
#include <string>
#include <vector>
#include <math.h>
#include <iostream>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int h = 3;
    int w;
    int sum = brown + yellow;

    for(int h = 3; h < sum ; h++) {
        if(sum%h==0){
            int w = sum / h;

            if(((w + h) * 2 - 4) == brown) {
                answer.push_back(w);
                answer.push_back(h);
                break;
                }
            }
        }
    return answer;
}