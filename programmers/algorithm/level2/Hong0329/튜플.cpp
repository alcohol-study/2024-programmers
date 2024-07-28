//
// Created by hong jun chung on 7/28/24.
//
#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    vector<int> v[501];
    vector<int> v2;
    string str;
    int m=0;
    bool visit[100001];

    for(int i=0;i<s.length();i++)
    {
        if(s[i]>='0'&&s[i]<='9')
            str+=s[i];
        else if(s[i]==',')
        {
            if(str.length()!=0)
                v2.push_back(stoi(str));
            str.clear();
        }
        else if(s[i]=='}')
        {
            if(str.length()!=0)
            {
                v2.push_back(stoi(str));
                str.clear();
            }
            if(v2.size()!=0)
            {
                m++;
                v[v2.size()]=v2;
                v2.clear();
            }
        }
    }

    fill(visit,visit+100001,false);
    for(int i=1;i<=m;i++)
    {
        for(int j=0;j<v[i].size();j++)
        {
            if(visit[v[i][j]]==false)
            {
                answer.push_back(v[i][j]);
                visit[v[i][j]]=true;
            }
        }

    }

    return answer;
}