from itertools import combinations
from functools import reduce

def solution(clothes):
    clothes_dict = {}
    lengths = []

    for c in clothes:
        clothes_dict[c[1]] = []

    for c in clothes:
        clothes_dict[c[1]].append(c[0])

    for v in clothes_dict.values():
        lengths.append(len(v))

    if len(lengths) == 1:
        return sum(lengths)
    answer = lengths[0] + 1
    for a in lengths[1:]:
        answer *= a + 1
    return answer -1


print(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))
print(solution([["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]))
print(solution([["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"], ["ddd", "d"], ["ffff", "f"]]))