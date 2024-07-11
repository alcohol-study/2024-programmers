//
// https://school.programmers.co.kr/learn/courses/30/lessons/42862
//
#include <string>
#include <vector>
#include <array>
#include <algorithm>
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;

    int arr[32]={0,0,};
    fill(arr,arr+32,0);

    for(int i=0;i<lost.size();i++)
        arr[lost[i]] -= 1;

    for(int i = 0; i< reserve.size(); i++) {
        arr[reserve[i]] += 1;
    }

    for(int i =1 ; i<=n; i++) {
        if(arr[i] == -1) {
            if(arr[i-1] == 1) {
                arr[i-1] = 0;
                arr[i] = 0;
            }
            else if(arr[i+1] == 1) {
                arr[i+1] = 0;
                arr[i] = 0;
            }
        }
        if(arr[i] >= 0)
            answer++;
    }
    return answer;
}