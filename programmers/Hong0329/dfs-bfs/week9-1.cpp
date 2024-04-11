//
// Created by hong jun chung on 4/11/24.
//
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int answer = 55;
bool visited[50];

bool check_diff(string a, string b) {
    int dif_cnt =0;

    for(int i=0; i<a.size();i++) {
        if(a[i]!=b[i]){
            dif_cnt++;
        }
    }
    if(dif_cnt==1){
        return true;
    }
    return false;
}

void dfs(string begin, string target,vector<string>words,int step){
    if(answer <= step)
        return;

    if(begin==target){
        answer = min(answer,step);
        return;
    }

    for(int i = 0 ; i < words.size() ; i++){
        if(check_diff(begin,words[i]) && !visited[i]){
            visited[i]=true;
            dfs(words[i],target,words,step+1);
            visited[i]=false;
        }
    }

    return;
}

int solution(string begin, string target, vector<string> words) {
    bool key = false;

    for(int i = 0; i<words.size();i++)
        if(words[i]==target)
            key = true;

    if(!key)
        return 0;
    else
        dfs(begin,target,words,0);

    return answer;
}