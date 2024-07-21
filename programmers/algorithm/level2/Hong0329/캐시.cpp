//
// Created by hong jun chung on 7/21/24.
//
#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;

    if(cacheSize == 0){
        answer = cities.size()*5;
        return answer;
    }

    vector<string> cache;
    for(int i=0; i<cities.size(); i++){
        string check = cities[i];
        transform(check.begin(), check.end(), check.begin(), ::tolower);

        auto it = find(cache.begin(), cache.end(), check);

        if(it != cache.end()){
            cache.erase(it);
            cache.push_back(check);
            answer++;

        }
        else{
            if(cache.size() < cacheSize)
                cache.push_back(check);
            else{
                cache.erase(cache.begin()+0);
                cache.push_back(check);
            }
            answer+=5;
        }
    }
    return answer;
}