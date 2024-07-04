//
// https://school.programmers.co.kr/learn/courses/30/lessons/1845
//
#include <vector>
#include <set>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;

    set<int> s(nums.begin(), nums.end());

    if(nums.size()/2 <= s.size())
        answer = nums.size()/2;
    else
        answer = s.size();

    return answer;
}