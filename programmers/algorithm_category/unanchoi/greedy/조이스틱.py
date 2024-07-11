def solution(name):
    answer = 0
    n = len(name)
    
    move = n-1

    for i, alpha in enumerate(name):
        
        # 작은 방향과 큰 방향으로 움직였을 때, 작은 값을 구함.
        answer += min(ord(alpha) - ord('A'), ord('Z') - ord(alpha) + 1)
        
        next_idx = i + 1

        # 이미 알파벳이 A이면 이동할 필요 없음.
        while next_idx < n and name[next_idx] == 'A':
            next_idx += 1
        
        move = min(move, i + n - next_idx + min(i, n - next_idx))
    
    answer += move

    return answer