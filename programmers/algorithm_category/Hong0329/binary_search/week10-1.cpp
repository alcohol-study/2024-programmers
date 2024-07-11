//
// https://school.programmers.co.kr/learn/courses/30/lessons/43238
//
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0;

    long long left = 1;
    long long right = (long long) *max_element(times.begin(), times.end()) * n;

    while(left <= right){
        long long mid = (left + right) / 2;

        long long cnt = 0;
        for(int i=0; i<times.size(); i++) {
            cnt += mid / times[i];
        }

        if(cnt < n) {
            left = mid + 1;
        } else {
            answer = mid;
            right = mid - 1;
        }
    }
    return answer;
}