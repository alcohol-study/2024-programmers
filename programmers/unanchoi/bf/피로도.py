from itertools import permutations

def solution(k, dungeons):
    answer_list = []

    all = []
    for p in permutations(dungeons, len(dungeons)):
        all.append(list(p))
    print(all)

    i = 0
    while i < len(all):
        answer = 0
        피로도 = k
        #print(dungeon)
        #print(len(dungeon))
        for d in all[i]:
            최소필요피로도 = d[0]
            소모피로도 = d[1]

            if 피로도 < 최소필요피로도:
                break
            else:
                피로도 -= 소모피로도
                answer += 1
           # print(피로도)
        answer_list.append(answer)
        i += 1
    print(answer_list)
    return max(answer_list)

print(solution(80, [[80,20],[50,40],[30,10]]))