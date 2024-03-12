def solution(sizes):
    max_num = 0
    min_num = 0

    new_sizes = []

    for size in sizes:
        new_sizes.append([max(size), min(size)])
    # 가장 긴 길이를 갖고 있는 페어 찾기
    for size in new_sizes:
        M = max(size)
        m = min(size)
        if max_num < M:
            max_num = M
            min_num = m

    for size in sizes:
        M = max(size)
        m = min(size)

        if m > min_num:
            min_num = m

    return max_num * min_num


print(solution([[60, 50], [30, 70], [60, 30], [80, 40]]	))
print(solution([[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]))
print(solution([[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]))
