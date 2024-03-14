from collections import deque

# bfs
def check(start, end, visited, graph):
    visited[start] = 1
    visited[end] = 1
    
    q = deque()
    q.append(end)
    cnt = 1

    while q:
        cur = q.popleft()

        for node in graph[cur]:
            if not visited[node]:
                visited[node] = 1
                cnt += 1
                q.append(node)

    return cnt

def solution(n, wires):
    answer = -1
    graph = [[] for _ in range(n+1)]
    
    # graph 생성
    for a, b in wires:
        graph[a].append(b)
        graph[b].append(a)

    answer = float("inf")

    # 순회
    for a,b in wires:
        visited = [0] * (n+1)
        cnt = check(a, b, visited, graph)
        x = abs(n - cnt)
        y = abs(cnt - x)
    return min(answer, y)

print(solution(9, [[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]))
print(solution(4, [[1,2],[2,3],[3,4]]))
print(solution(7, [[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	))