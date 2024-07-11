from functools import cmp_to_key


def compare(x, y):
    if str(x)+str(y) > str(y)+str(x):
    	return -1
    elif str(x)+str(y) == str(y)+str(x):
    	return 0
    else:
    	return 1
    

def solution(numbers):
	numbers=sorted(numbers, key=cmp_to_key(compare))
	return str(int("".join(map(str, numbers))))

print(solution([6, 10, 2]))
print(solution([3, 30, 34, 5, 9]))
print(solution([1, 10, 100, 112, 200, 21]))

# 200 112 1 10 100
# 9 5 34 3 30