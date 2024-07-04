from collections import defaultdict 

def solution(genres, plays):
    answer = []
    l = len(genres)
    albums = []

    # 해시 생성
    for i in range(l):
        albums.append({"genre": genres[i], "play": plays[i], "index": i})

    # 가장 횟수가 큰 장르를 구함.
    a = defaultdict(int)
    for i in albums:
        a[i["genre"]] += i["play"]
    # 많이 나온 장르 순으로 정렬
    genre_desc = sorted(a, key=lambda x: a[x], reverse=True)

    genre_count = defaultdict(int)
    
    sorted_item = sorted(albums, key=lambda x: ((genre_desc.index(x["genre"])), -x["play"], x["index"]))

    for i in sorted_item:
        if genre_count[i["genre"]] >= 2:
            continue
        genre_count[i["genre"]] += 1
        answer.append(i["index"])
    return answer

print(solution(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]))