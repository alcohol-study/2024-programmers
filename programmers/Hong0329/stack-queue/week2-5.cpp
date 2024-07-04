//
// https://school.programmers.co.kr/learn/courses/30/lessons/42583
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int sum =0;
    int i = 1;
    int time = 1;
    vector<pair<int,int>>vec;

    vec.push_back(make_pair(1,truck_weights[0]));
    sum += truck_weights[0];

    while(!vec.empty()) {
        int a = vec.front().first;
        int b = vec.front().second;

        if(a >= bridge_length) {
            sum -= b;
            vec.erase(vec.begin());
        }

        if(i < truck_weights.size() && sum + truck_weights[i] <= weight) {
            sum += truck_weights[i];
            vec.push_back(make_pair(0,truck_weights[i]));
            i++;
        }

        for(int j =0;j<vec.size();j++)
            vec[j].first++;

        time++;
    }
    answer = time;
    return answer;
}