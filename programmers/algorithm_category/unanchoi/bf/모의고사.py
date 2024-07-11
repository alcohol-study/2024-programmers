def solution(answers):
    answer = []
    l = len(answers)
    일번 = [1,2,3,4,5]
    이번 = [2,1,2,3,2,4,2,5]
    삼번 = [3,3,1,1,2,2,4,4,5,5]
    one_correct = 0
    two_correct = 0
    three_correct = 0

    for i in range(l):
        ith_ans = answers[i]

        if 일번[i % 5]  == ith_ans:
            one_correct += 1
        
        if 이번[i % 8]  == ith_ans:
            two_correct += 1

        if 삼번[i % 10] == ith_ans:
            three_correct += 1

    x = [one_correct, two_correct, three_correct]
    for i in range(len(x)):
        if x[i] == max(x):
            answer.append(i+1)

    answer.sort()
    return answer

print(solution([1,2,3,4,5]))
print(solution([1,3,2,4,2]))