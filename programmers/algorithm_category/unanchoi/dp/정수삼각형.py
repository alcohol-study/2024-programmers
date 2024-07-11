def solution(triangle):
    n = len(triangle)
    
    cache = [[0] * i for i in range(1, n+1)]
    cache[0][0] = triangle[0][0]
    
    for i in range(1, n):
        for j in range(i+1):

            if j == 0:
                cache[i][j] = cache[i-1][j] + triangle[i][j]
            elif j == i:
                cache[i][j] = cache[i-1][j-1] + triangle[i][j]
            
            else:
                # 둘 중 큰 값 선택
                cache[i][j] = max(cache[i-1][j-1], cache[i-1][j]) + triangle[i][j]
    
    return max(cache[n-1])

print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))