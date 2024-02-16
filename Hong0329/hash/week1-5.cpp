//
// https://school.programmers.co.kr/learn/courses/30/lessons/42579
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

bool genreSort(pair<string, int> a, pair<string, int> b){
    return a.second > b.second;
}

bool musicPlaySort(pair<int,int>a, pair<int, int>b){
    if(a.first == b.first)
        return a.second < b.second;
    else
        return a.first > b.first;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    unordered_map <string,vector<pair<int,int>>> musicInfo;
    unordered_map <string, int> genrePlays;

    for(int i=0; i<genres.size(); i++) {
        musicInfo[genres[i]].push_back({plays[i], i});
        genrePlays[genres[i]]+=plays[i];
    }

    for(auto &x : musicInfo) {
        sort(x.second.begin(), x.second.end(), musicPlaySort);
    }

    vector <pair<string, int>> genreVec(genrePlays.begin(),genrePlays.end());

    sort(genreVec.begin(),genreVec.end(),genreSort);

    for(auto gen : genreVec) {
        for(int j = 0 ; j < musicInfo[gen.first].size(); j++){
            answer.push_back(musicInfo[gen.first][j].second);

            if(j)
                break;
        }
    }
    return answer;
}