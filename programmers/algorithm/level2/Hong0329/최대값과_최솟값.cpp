//
// https://school.programmers.co.kr/learn/courses/30/lessons/12939
//
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string s) {
    string answer = "";

    vector<int> v;
    string str;

    for(int i = 0; i<s.length(); i++) {
        if(s[i] != ' ') {
            str += s[i];
        }
        else {
            v.push_back(stoi(str));
            str.clear();
        }
    }
    v. push_back(stoi(str));

    sort(v.begin(), v.end());

    answer += to_string(v.front()) + " " + to_string(v.back());
    return answer;
}