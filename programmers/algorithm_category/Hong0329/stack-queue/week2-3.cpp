//
// https://school.programmers.co.kr/learn/courses/30/lessons/12909
//
#include<string>
#include <iostream>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    int key =0;
    for(int i=0;i<s.length();i++){
        if(s[i] =='(') key++;
        else {
            key--;
            if(key<0){
                answer = false;
                break;
            }
        }
    }
    if(key!=0)answer=false;
    return answer;
}