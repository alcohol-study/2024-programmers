//
// https://school.programmers.co.kr/learn/courses/30/lessons/42860
//
#include <string>
#include <vector>
#include <math.h>
#include <algorithm>
#include <iostream>

using namespace std;

int check(char a, char b){
    int key = abs(int(a) - int(b));
    if(key == 0)
        return 0;
    else{
        if(key>=14)
            return abs(26-key);
        else
            return key;
    }
}

int solution(string name) {
    int answer = 0;
    int move = name.size() - 1;

    for(int i =0 ; i< name.size();i++) {
        answer += check('A',name[i]);
        cout << check('A',name[i]) << "/";
        int next = i+1;

        while(next<name.size() && name[next] == 'A')
            next++;
        int a = name.size() - next;
        move = min(move, i + a + min(i, a));
    }
    answer += move;

    return answer;
}