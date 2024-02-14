//
// https://school.programmers.co.kr/learn/courses/30/lessons/42577
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    string phone1 = "";
    string phone2 = "";

    sort(phone_book.begin(), phone_book.end());

    for(int i = 0 ; i < phone_book.size() - 1 ; i++) {
        phone1 = phone_book[i];
        phone2 = phone_book[i+1].substr(0, phone1.size());

        if(phone1 == phone2) {
            answer = false;
            break;
        }
    }
    return answer;
}