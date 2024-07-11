from itertools import permutations
import math

def find_p(n: int) -> bool:
    if n == 1:
        return False
    # (n // int(math.sqrt(n))) + 1
    for i in range(2, n):
        if n % i == 0:
            return False
    return True
    

def solution(numbers):
    c_numbers = list(numbers)
    result = []

    for i in range(1,len(c_numbers)+1):
        result += permutations(c_numbers, i)

    result = list(result)
    answer_list = []

    for r in result:
        n = "".join(r)
        if n == "0":
            continue
        if n == "2":
            if 2 in answer_list:
                pass
            else:
                answer_list.append(2)
        
        if n == "1":
            continue
        
        if int(n[-1]) % 2 == 0:
            continue

        if find_p(int(n)):
            if int(n) in answer_list:
                pass
            else:
                answer_list.append(int(n))
    answer_list.sort()
    return len(answer_list)
print(solution("17"))
print(solution("011"))
print(solution("2220"))
print(solution("013"))
print(solution("12345"))
print(solution("123"))
print(solution("110"))