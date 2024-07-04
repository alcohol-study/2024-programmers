//
// Created by hong jun chung on 6/20/24.
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;

    sort(people.begin(),people.end(),greater<int>());

    int start=0,end=people.size()-1;

    while(start<end){
        if(people[start]+people[end]<=limit)
        {
            end--;
        }

        answer++;
        start++;
    }
    if(start==end)
        answer++;
    return answer;
}