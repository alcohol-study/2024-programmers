//
//
//
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    int cnt = -1;

    for(int i =number.size()-k ; i>0; i--) {
        char maxN = ' ';
        for(int j = cnt + 1; j<= number.size()-i; j++) {
            if(maxN < number[j]) {
                maxN = number[j];
                cnt = j;
            }}
        answer += maxN;
    }
    return answer;
}