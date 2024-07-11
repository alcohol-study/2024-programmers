from collections import deque

def solution(arrows):
    dx = [-1, -1, 0, 1, 1, 1, 0, -1]
    dy = [0, 1, 1, 1, 0, -1, -1, -1]

    visited = set([(0, 0)])
    edges = set()
    x, y = 0, 0
    answer = 0

    for arrow in arrows:
        for _ in range(2):
            nx, ny = x + dx[arrow], y + dy[arrow]
            if (x, y, nx, ny) not in edges:
                edges.add((x, y, nx, ny))
                edges.add((nx, ny, x, y))

                if (nx, ny) in visited:
                    answer += 1
                else:
                    visited.add((nx, ny))

            x, y = nx, ny

    return answer
