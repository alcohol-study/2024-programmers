from itertools import permutations

def solution(word):
    
    word_list = []

    모음 = ['A', 'E', 'I', 'O', 'U'] * 5
    
    for i in range(1, 6):
        for p in permutations(모음, i):
            word_list.append("".join(p))
    
    word_list = list(set(list(word_list)))

    word_list.sort()

    return word_list.index(word) + 1

print(solution("AAAAE"))
print(solution("AAAE"))
print(solution("I"))
print(solution("EIO"))