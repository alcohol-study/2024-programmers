"""
이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

명령어	수신 탑(높이)
I 숫자	큐에 주어진 숫자를 삽입합니다.
D 1	큐에서 최댓값을 삭제합니다.
D -1	큐에서 최솟값을 삭제합니다.
이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때,
모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 
[최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.

operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
operations의 원소는 큐가 수행할 연산을 나타냅니다.
원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.

16과 -5643을 삽입합니다.
최솟값을 삭제합니다. -5643이 삭제되고 16이 남아있습니다.
최댓값을 삭제합니다. 16이 삭제되고 이중 우선순위 큐는 비어있습니다.
우선순위 큐가 비어있으므로 최댓값 삭제 연산이 무시됩니다.
123을 삽입합니다.
최솟값을 삭제합니다. 123이 삭제되고 이중 우선순위 큐는 비어있습니다.

"""

import heapq

def solution(operations):
    heap = []

    for oper in operations:
        l = oper.split(" ")
        command = l[0]
        num = l[1]
        
        if (command == "D"):
            if len(heap) == 0:
                continue

            if num == "1":
                heap.sort()
                heap.pop()
                # O(N)
                heapq.heapify(heap)
            elif num == "-1":
                heapq.heappop(heap)
            else:
                pass

        else:
            heapq.heappush(heap, int(num))

    if len(heap) == 0:
        return [0,0]
    
    L = heapq.nlargest(1, heap)[0]
    S = heapq.nsmallest(1, heap)[0]
    return [L,S]

print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))
print(solution(["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]))
