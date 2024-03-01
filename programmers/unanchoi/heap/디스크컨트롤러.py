import heapq

def solution(jobs):
    heap = []
    l = len(jobs)
    start = -1
    answer = 0
    now = 0
    idx = 0
    while idx < len(jobs):
        for job in jobs:
            if (start < job[0] <= now):
                heapq.heappush(heap, (job[1], job[0]))

        if heap:
            x = heapq.heappop(heap)
            start = now
            now += x[0]
            answer = answer + now - x[1]
            idx += 1 
        else:
            now += 1
    return answer // l

print(solution([[0, 3], [1, 9], [2, 6]]))