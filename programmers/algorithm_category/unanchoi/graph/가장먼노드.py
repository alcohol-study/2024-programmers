from collections import deque

def solution(n, vertex):
    graph = [[] for _ in range(n + 1)]
    for v in vertex:
        graph[v[0]].append(v[1])
        graph[v[1]].append(v[0])
      
    distances = [0] * (n + 1)
    visited = [False] * (n + 1)
    queue = deque([(1, 0)])  
    visited[1] = True

    while queue:
        node, distance = queue.popleft()
        distances[node] = distance

        for neighbor in graph[node]:
            if not visited[neighbor]:
                queue.append((neighbor, distance + 1))
                visited[neighbor] = True

    max_distance = max(distances)
    count = distances.count(max_distance)

    return count
