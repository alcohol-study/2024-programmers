from collections import deque

def solution(bridge_length, weight, truck_weights):
    bridge = [0] * bridge_length
    truck_passed = list()
    truck_queue = deque(truck_weights)
    time = 1
    w = 0
    while len(truck_passed) < len(truck_weights):
        time += 1
        last = bridge.pop(0)
        
        if last != 0:
            truck_passed.append(last)
            w -= last

        if len(truck_queue) > 0:
            if w + truck_queue[0] <= weight:
                n = truck_queue.popleft()
                bridge.append(n)
                w += n
            else:
                bridge.append(0)
    return time-1

print(solution(2, 10, [7,4,5,6]))