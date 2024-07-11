//
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
//
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <set>
#include <math.h>

using namespace std;
bool check(int n) {
    if(n < 2)
        return false;
    else {
        for(int i = 2; i<=int(sqrt(double(n))); i++)
            if(n % i == 0)
                return false;
    }
    return true;
}

int solution(string numbers) {
    int answer = 0;
    set<int> s;
    sort(numbers.begin(), numbers.end());

    do {
        for(int j = 0; j<numbers.size(); j++) {
            if(check(stoi(numbers.substr(0, j+1))))
                s.insert(stoi(numbers.substr(0, j+1)));
        }
    } while(next_permutation(numbers.begin(), numbers.end()));
    answer = s.size();
    return answer;
}