//
// https://school.programmers.co.kr/learn/courses/30/lessons/42895
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <set>

using namespace std;

int solution(int N, int number) {
    int answer = -1;
    set<int> dp[9];
    int cnt = 0;

    for(int i = 1; i<=8; i++) {
        cnt = cnt * 10 + N;
        dp[i].insert(cnt);
    }

    for(int i = 1; i<=8; i++) {
        for(int j = 1; j<=i; j++) {
            for(auto a : dp[j]) {
                for(auto b : dp[i-j]) {
                    dp[i].insert(a+b);
                    if(!((a - b) <=0))
                        dp[i].insert(a-b);
                    if(a!=0 && b!=0) {
                        dp[i].insert(a*b);
                        if(a%b == 0)
                            dp[i].insert(a/b);
                    }
                }
            }
        }
        if(dp[i].find(number) != dp[i].end()) {
            answer = i;
            break;
        }
    }

    return answer;
}