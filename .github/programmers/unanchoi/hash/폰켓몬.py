from collections import Counter

def solution(nums):
    answer = 0
    dict = Counter(nums)
    x = [k for k in dict.keys()]

    if len(dict.keys()) > len(nums) // 2:
        return len(nums) // 2
    else:
        return len(dict.keys())