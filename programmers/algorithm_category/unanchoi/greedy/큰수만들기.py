def solution(number, k):
    num_list = []
    
    for num in number:
        # number를 순회하면서 num 보다 작은 숫자를 제거해 나간다.
        while num_list and num_list[-1] < num and k > 0:
            num_list.pop()
            k -= 1
        num_list.append(num)
    
    if k > 0:
        num_list = num_list[:-k]
    
    # 제거한 숫자 join
    return ''.join(num_list)