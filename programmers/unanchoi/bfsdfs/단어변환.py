from collections import deque

def solution(begin, target, words):
    if target not in words:
        return 0
    
    def is_adjacent(word1, word2):
        return sum(c1 != c2 for c1, c2 in zip(word1, word2)) == 1
    
    visited = set()
    queue = deque([(begin, 0)])

    while queue:
        current_word, level = queue.popleft()
        if current_word == target:
            return level
        
        for word in words:
            if word not in visited and is_adjacent(current_word, word):
                visited.add(word)
                queue.append((word, level + 1))

print(solution("hit","cog", ["hot", "dot", "dog", "lot", "log", "cog"]))

