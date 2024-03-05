//
// https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=cpp
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool cmp(const string &a, const string &b) {
    return a + b > b + a;
}

string solution(vector<int> numbers) {
    string answer = "";
    vector<string> vs;

    for(int i =0 ; i< numbers.size(); i++) {
        vs.push_back(to_string(numbers[i]));
    }
    sort(vs.begin(), vs.end(), cmp);

    for(int j =0;j<numbers.size();j++) answer += vs[j];

    if(answer[0] == '0') answer = '0';

    return answer;
}