//
// https://school.programmers.co.kr/learn/courses/30/lessons/42840
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> player;
    int a = 0;
    int b = 0;
    int c = 0;
    int cnt = answers.size();
    int arr[5] = {1,2,3,4,5};
    int brr[8] = {2,1,2,3,2,4,2,5};
    int crr[10] = {3,3,1,1,2,2,4,4,5,5};

    for(int i = 0 ; i < cnt ; i++){
        if(answers[i] == arr[i%5])
            a++;
        if(answers[i] == brr[i%8])
            b++;
        if(answers[i] == crr[i%10])
            c++;
    }
    player.push_back(a);
    player.push_back(b);
    player.push_back(c);

    int max_score = *max_element(player.begin(), player.end());

    for(int j =0 ;j<3;j++){
        if(player[j] == max_score) answer.push_back(j+1);
    }
    return answer;
}