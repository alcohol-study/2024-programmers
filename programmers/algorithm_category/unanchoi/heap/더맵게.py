"""
제한 사항
scoville의 길이는 2 이상 1,000,000 이하입니다.
K는 0 이상 1,000,000,000 이하입니다.
scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
"""

import heapq

def solution(scoville, K):
    answer = 0
    scoville_heap = []

    if len(scoville) == 0:
        return answer

    for s in scoville:
        heapq.heappush(scoville_heap, s)

    while check_condition(scoville_heap, K):
        if len(scoville_heap) == 1:
            if check_condition(scoville_heap, K):
                return -1
        first = heapq.heappop(scoville_heap)
        second = heapq.heappop(scoville_heap)
        new = first + second * 2
        heapq.heappush(scoville_heap, new)
        answer += 1

    return answer

def check_condition(heap, k):
    for h in heap:
        if h < k:
            return True
    return False

print(solution([1, 2, 3, 9, 10, 12], 7))