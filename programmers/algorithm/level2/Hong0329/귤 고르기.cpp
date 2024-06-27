//
// Created by hong jun chung on 6/27/24.
//
#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

int solution(int k, vector<int> tangerine) {
    int answer = 0;

    map<int,int> m;
    for(int t : tangerine)
        m[t]++;

    vector<int> vec;

    for(auto n : m)
        vec.push_back(n.second);

    sort(vec.begin(), vec.end(), greater<int>());

    int sum = 0;
    for(int v : vec)
    {
        if(sum >= k)
            break;
        sum += v;
        answer++;
    }

    return answer;
}