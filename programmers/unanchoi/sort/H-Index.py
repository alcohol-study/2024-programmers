"""
문제 설명
H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 
어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다.
 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.

어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 
나머지 n-h개 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

# [3, 0, 6, 1, 9, 10, 12, 4]))

어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 
이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

제한사항z 
과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

"""

# min ~ max
def solution(citations):
    answer_list = []

    min_c = max(0, min(citations))
    max_c = max(citations)

    # 0 1 2 3 4 5 6
    for h in range(0, max_c+1):
        cnt = 0
        # 3 0 6 1 5
        for c in citations:
            if c >= h:
                cnt += 1

        if cnt >= h and (len(citations) - cnt) <= h:
            answer_list.append(h)
        cnt = 0
    
    if len(answer_list) == 0:
        return 0

    return max(answer_list)

print(solution([3, 0, 6, 1, 5]))
print(solution([3, 0, 6, 1, 5, 10, 12]))
print(solution([3, 0, 6, 1, 9, 10, 12, 4]))
print(solution([1,10,11]))
print(solution([10,11]))
print(solution([0,0,0,0]))
print(solution([0]))
print(solution([6, 5, 3, 3, 0]))
print(solution([3, 4]))
print(solution([0, 2]))
print(solution([0, 1]))
print(solution([0, 0]))
print(solution([1, 1]))
