def solution(prices):
    answer = []
    l = len(prices)

    for i in range(l):
        num = 0
        for j in range(i+1, l):
            if prices[j] < prices[i]:
                num += 1
                break
            num += 1
        answer.append(num)
        
    return answer

print(solution([1, 2, 3, 2, 3]))