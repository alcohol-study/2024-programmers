def solution(participant, completion):
    answer = ''
    participant.sort()
    completion.sort()

    for idx in range(len(completion)):
        if participant[idx] != completion[idx]:
            return participant[idx]
    return participant[-1]

print(solution(["leo", "kiki", "eden"], ["eden", "kiki"]))
