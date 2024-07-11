from collections import defaultdict

def solution(tickets):
    graph = defaultdict(list)
    for a, b in tickets:
        graph[a].append(b)
    
    for a in graph:
        graph[a].sort()
    
    route = []
    
    def dfs(a):
        while graph[a]:
            dfs(graph[a].pop(0))
        route.append(a)
    
    dfs("ICN")
    
    return route[::-1]

print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))