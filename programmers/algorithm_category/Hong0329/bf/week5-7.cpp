//
// https://school.programmers.co.kr/learn/courses/30/lessons/84512
//
#include <string>
#include <vector>

using namespace std;

string s = "AEIOU";
int answer = 0;
int cnt = 0;

void dfs(string now, string word){
    if(now == word)
        answer = cnt;
    if(now.length() > 5)
        return;
    cnt++;
    for(int i = 0 ; i < s.length() ; i++)
        dfs(now + s[i], word);
}

int solution(string word) {
    dfs("", word);
    return answer;
}