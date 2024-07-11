dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

# (x_idx, y_idx) 들을 min 값, 즉 가장 좌측 상단의 값을 기준으로 일반화 하는 함수 입니다.
# 이후 비교에 시간적 우위를 가져갑니다.
def normalize_set(before):
    min_x, min_y = min(before)
    after =  {(x - min_x, y -  min_y) for x, y in before}
    return after


# 기존 idx 들을 회전시킨 함수를 반환하는 함수 입니다.
def spining_set(original):
    spin_90 = set()
    spin_180 = set()
    spin_270 = set()
    while original:
        x, y = original.pop()
        spin_90.add((y, -x))
        spin_180.add((-x, -y))
        spin_270.add((-y, x))
    return spin_90, spin_180, spin_270


# 시작 좌표를 기점으로 aim, 즉 목표 값을 가지는 연결된 좌표들을 전부 기록하여 반환합니다.
# 이때, 90도, 180도, 270도 로 회전한 idx들도 일반화 하여 반환 합니다.
def dfs(a, b, height, wide, board, aim):
    # visited의 역할을 합니다.
    idx_set = {(a, b), }
    # 다음에 밟을 친구들을 저장해줍니다. 기본적인 델타 탐색처럼 기동합니다.
    queue = {(a, b), }
    while queue:
        x, y = queue.pop()
        for direction in range(4):
            px = x + dx[direction]
            py = y + dy[direction]
            if 0 <= px < height and 0 <= py < wide and (px, py) not in idx_set and board[px][py] == aim:
                idx_set.add((px, py))
                queue.add((px, py))
    length = len(idx_set)
    # 반환 값들을 위한 기본 세팅을 합니다.
    # 돌려준 값들을 저장합니다. 이때, set()으로 감싸서 기존의 set이 손상되는 것을 막습니다.
    turn_90, turn_180, turn_270 = spining_set(set(idx_set))

    # 각 좌표들을 일반화 합니다.
    turn_0 = normalize_set(idx_set)
    turn_90 = normalize_set(turn_90)
    turn_180 = normalize_set(turn_180)
    turn_270 = normalize_set(turn_270)

    return length, idx_set, turn_0, turn_90, turn_180, turn_270,

def solution(game_board, table):
    width = len(game_board)
    board_visited = set()
    board_dict = dict()
    table_visited = set()
    table_dict = dict()
    # 이중 for문으로 탐색하면서 각 좌표가 목표하는 값을 가지면, dfs 함수를 사용하여 좌표 추출을 진행합니다.
    for i in range(width):
        for j in range(width):
            # 해당 위치의 값이 빈 자리라면, 빈자리의 좌표들을 추출합니다.

            if game_board[i][j] == 0 and (i, j) not in board_visited:
                # 빈자리의 길이, 빈자리들의 idx, 0도 회전, 90도 회전, 180도 회전, 270도 회전 = dfs 함수(i, j, 높이, 너비, 참고할 grid, 목표 값)
                empty_length, empty_visited, empty_0, empty_90, empty_180, empty_270 = dfs(i, j, width, width, game_board, 0)
                # 밟은 위치를 추가해줍니다.
                board_visited |= empty_visited

                # 이미 해당 길이가 dict에 있다면, 거기에 이번에 새로 뽑은 일반화된 좌표 목록(x4)를 추가해줍니다.
                if empty_length not in board_dict.keys():
                    board_dict[empty_length] = [[empty_0, empty_90, empty_180, empty_270], ]
                else:
                    board_dict[empty_length].append([empty_0, empty_90, empty_180, empty_270])
            # 해당 위치의 값이 블록이라면, 해당 블록의 좌표들을 추출합니다.
            if table[i][j] == 1 and (i, j) not in table_visited:
                table_length, block_visited, table_0, table_90, table_180, table_270 = dfs(i, j, width, width, table, 1)
                table_visited |= block_visited
                if table_length not in table_dict.keys():
                    table_dict[table_length] = [[table_0, table_90, table_180, table_270], ]
                else:
                    table_dict[table_length].append([table_0, table_90, table_180, table_270])
    answer = 0        
    fit_visited = set()
    # 각 블록과 빈자리 dict에서 같은 길이의 빈자리~블록 끼리만 비교합니다.
    for block_length in table_dict.keys():
        if block_length in board_dict.keys():
            # 동일 길이를 가지는 빈자리와 블록들을 나열해놓고 비교합니다.
            block_list = table_dict[block_length]
            empty_list = board_dict[block_length]
            for block_idx in range(len(block_list)):
                for empty_idx in range(len(empty_list)):
                    # 현재 길이에서 이미 뽑힌 빈자리를 기록하여 다시 밟지 않습니다.
                    if (block_length, empty_idx) in fit_visited:
                        continue
                    else:
                        # 들어맞으면 백트래킹 합니다. fit_flag == True 라면 이미 조각이 맞았다는 뜻입니다.
                        fit_flag = False
                        # 0도 90도 180도 270도 회전한 각 set들을 비교하면 빠르게 진행 가능합니다.
                        for i in range(4):
                            if fit_flag:
                                break
                            for j in range(i, 4):
                                if block_list[block_idx][i] == empty_list[empty_idx][j]:
                                    fit_flag = True
                                    # 현재 블록(빈자리)의 길이를 answer에 더해주고 visited에도 (길이, 빈자리 idx)로 저장해줍니다.
                                    fit_visited.add((block_length, empty_idx))
                                    answer += block_length
                                    break
                        # 백트래킹(위와 동일)
                        if fit_flag:
                            break

    return answer
