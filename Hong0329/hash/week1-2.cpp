//
// https://school.programmers.co.kr/learn/courses/30/lessons/42576
//
#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>
using namespace std;


string solution(vector<string> participant, vector<string> completion)
{
    string answer = "";
    unordered_map<string, int> map;

    for (int i = 0 ; i < participant.size() ; i++)
    {
        if (map.end() == map.find(participant[i]))
            map.insert(make_pair(participant[i], 1));
        else
            map[participant[i]]++;
    }

    for (int j = 0 ; j < completion.size() ; j++)
        map[completion[j]]--;

    for(int t = 0 ; t < participant.size() ; t++){
        if (map[participant[t]] > 0)
        {
            answer = participant[t];
            break;
        }
    }
    return answer;
}