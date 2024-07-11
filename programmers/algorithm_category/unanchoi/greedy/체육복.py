def solution(n, lost, reserve):
    initial_l = len(reserve)
    lost.sort()
    reserve.sort()
    
    for l in lost:
        lower_num = l - 1
        higher_num = l + 1
        
        if l in reserve:
            reserve.remove(l)
            continue
        
        if lower_num in reserve and lower_num not in lost:
            reserve.remove(lower_num)
            continue
        
        if higher_num in reserve and higher_num not in lost:
            reserve.remove(higher_num)
            continue

    return n - (len(lost) - initial_l + len(reserve))

# 번호 하나 차이가 나면 빌려줄 수 있다.

print(solution(5, [2, 4], [1,3,5]))
print(solution(5, [2, 4], [3]))
print(solution(3, [3], [1]))
print(solution(5, [1,2,3], [2,3,4]))