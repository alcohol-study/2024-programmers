def solution(m, n, puddles):
    dp = [[0] * (m + 1) for _ in range(n + 1)]
    dp[1][1] = 1
    
    for x, y in puddles:
        dp[y][x] = -1
    
    for i in range(1, n + 1):
        
        for j in range(1, m + 1):

            if dp[i][j] == -1:
                continue
            if i == 1 and j == 1:
                continue
            
            up = dp[i - 1][j] if dp[i - 1][j] != -1 else 0
            left = dp[i][j - 1] if dp[i][j - 1] != -1 else 0
            
            dp[i][j] = (up + left) % 1000_000_007
    
    return dp[n][m]