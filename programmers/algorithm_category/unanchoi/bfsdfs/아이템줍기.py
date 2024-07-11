def solution(rectangle, characterX, characterY, itemX, itemY):
    rectangle = [[x*2 for x in r] for r in rectangle]
    characterX *= 2
    characterY *= 2
    itemX *= 2
    itemY *= 2

    max_x = max(r[2] for r in rectangle)
    max_y = max(r[3] for r in rectangle)
    board = [[0] * (max_x + 2) for _ in range(max_y + 2)]

    # 직사각형 내부를 1로 변경
    for x1, y1, x2, y2 in rectangle:
        for i in range(y1, y2 + 1):
            for j in range(x1, x2 + 1):
                board[i][j] = 1

    # 테두리를 0으로 교체
    for x1, y1, x2, y2 in rectangle:
        for i in range(y1 + 1, y2):
            for j in range(x1 + 1, x2):
                board[i][j] = 0

    queue = [(characterX, characterY, 0)]
    visited = [[0] * (max_x + 2) for _ in range(max_y + 2)]
    visited[characterY][characterX] = 1

    while queue:
        x, y, distance = queue.pop(0)
        if x == itemX and y == itemY:
            return distance // 2

        for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx <= max_x + 1 and 0 <= ny <= max_y + 1 and board[ny][nx] == 1 and visited[ny][nx] == 0:
                queue.append((nx, ny, distance + 1))
                visited[ny][nx] = 1

    return -1