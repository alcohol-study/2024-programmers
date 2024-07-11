//
// https://school.programmers.co.kr/learn/courses/30/lessons/87694
//
#include <string>
#include <vector>
#include <iostream>
using namespace std;

int visit[101][101]={0};
int answer = 987654321;

int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};


void find(int a,int b,int ans_a, int ans_b, int count) {
    if(a==ans_a and b==ans_b) {
        answer=min(answer,count);
        return;
    }

    for(int i=0;i<4;i++) {
        if(visit[a+dx[i]][b+dy[i]]==1) {
            visit[a+dx[i]][b+dy[i]]=0;
            find(a+dx[i],b+dy[i],ans_a,ans_b,count+1);
            visit[a+dx[i]][b+dy[i]]=1;
        }
    }
}

int solution(vector<vector<int>> rectangle, int characterX, int characterY, int itemX, int itemY) {

    characterX *= 2, characterY *= 2, itemX *= 2, itemY *= 2;

    for(int i=0;i<rectangle.size();i++) {
        for(int a=rectangle[i][0]*2;a<=rectangle[i][2]*2;a++){
            for(int b=rectangle[i][1]*2;b<=rectangle[i][3]*2;b++)
                visit[a][b]=1;
        }
    }

    for(int i=0;i<rectangle.size();i++) {
        for(int a=rectangle[i][0]*2+1;a<=rectangle[i][2]*2-1;a++){
            for(int b=rectangle[i][1]*2+1;b<=rectangle[i][3]*2-1;b++)
                visit[a][b]=0;
        }
    }

    visit[characterX][characterY]=1;
    find(characterX,characterY,itemX,itemY,0);



    return answer/2;
}