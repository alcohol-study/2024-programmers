//
// Created by hong jun chung on 8/25/24.
//
#include <string>
#include <vector>
#include <map>
using namespace std;

map<string, int> dic;

string subSTR(string s, int n){
    string r = "";

    for(int i = n; i < s.size(); i++){
        r += s[i];
    }

    return r;
}

vector<int> solution(string msg) {
    vector<int> answer;

    for(char i = 'A'; i <= 'Z'; i++){
        string tmp = "";
        tmp.push_back(i);
        dic.insert({tmp, i - 'A' + 1});
    }

    int idx = 0;
    while(msg.size() > 0){
        string w = "";
        string wc = "";
        int i;
        for(i = 0; i < msg.size(); i++){
            w += msg[i];

            if(dic.find(w) == dic.end()){
                wc = w;
                w.pop_back();
                break;
            }
        }
        dic.insert({wc, dic.size() + 1});
        answer.push_back(dic[w]);
        msg = subSTR(msg, i);
    }

    return answer;
}