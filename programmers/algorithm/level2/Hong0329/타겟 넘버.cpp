//
// Created by hong jun chung on 8/11/24.
//
#include <string>
#include <vector>

using namespace std;

int answer = 0;

void dfs(vector<int> numbers, int target, int sum, int num) {
    if(num == numbers.size()) {
        if(sum == target) {
            answer++;
        }
        return;
    }
    dfs(numbers, target, sum + numbers[num], num + 1);
    dfs(numbers, target, sum - numbers[num], num + 1);
}

int solution(vector<int> numbers, int target) {
    dfs(numbers, target, 0, 0);
    return answer;
}