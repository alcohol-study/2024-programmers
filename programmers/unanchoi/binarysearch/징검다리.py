def solution(distance, rocks, n):
    rocks.sort()  
    rocks.append(distance)  
    
    left, right = 0, distance
    while left <= right:
        mid = (left + right) // 2
        min_distance = float('inf')
        current = 0
        removed_rocks = 0
        
        for rock in rocks:
            diff = rock - current
            if diff < mid:
                removed_rocks += 1
            else:
                min_distance = min(min_distance, diff)
                current = rock
        
        if removed_rocks > n:
            right = mid - 1
        else:
            left = mid + 1
            answer = min_distance
    
    return answer

print(solution(25, [2, 14, 11, 21, 17], 2))