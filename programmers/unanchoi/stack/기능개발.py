def solution(progresses, speeds):
    numbers = []
    for i in range(len(progresses)):
        p = progresses[i]
        s = speeds[i]
        
        if (100 - p) % s == 0:
            numbers.append((100-p)//s)
        else:
            numbers.append((100-p)//s + 1)
    answer = []
    s = 1
    M = numbers[0]
    # 7 3 9
    # 5 10 1 1 20 1
    # 5 5 1 1 10 10
    for i in range(1, len(numbers)):
        if numbers[i] > M:
            answer.append(s)
            M = numbers[i]
            s = 1
        else:
            s += 1
    answer.append(s)
    return answer
#  5 10 1 2 20 19 18 17 5
print(solution([93, 30, 55], [1, 30, 5]	))
print(solution([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1]	))