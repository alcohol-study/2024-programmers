def solution(arr):
    n = len(arr)
    dp_max = [[0] * n for _ in range(n)]
    dp_min = [[0] * n for _ in range(n)]

    for i in range(0, n, 2):
        dp_max[i][i] = int(arr[i])
        dp_min[i][i] = int(arr[i])

    for size in range(2, n, 2):
        for i in range(0, n - size, 2):
            j = i + size
            dp_max[i][j], dp_min[i][j] = calc_min_max(arr, i, j, dp_max, dp_min)

    return dp_max[0][n - 1]

def calc_min_max(arr, start, end, dp_max, dp_min):
    max_val = float('-inf')
    min_val = float('inf')

    for k in range(start + 1, end, 2):
        if arr[k] == '+':
            max_val = max(max_val, dp_max[start][k - 1] + dp_max[k + 1][end])
            min_val = min(min_val, dp_min[start][k - 1] + dp_min[k + 1][end])
        else:
            max_val = max(max_val, dp_max[start][k - 1] - dp_min[k + 1][end])
            min_val = min(min_val, dp_min[start][k - 1] - dp_max[k + 1][end])

    return max_val, min_val