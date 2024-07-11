def solution(phone_book):
    if (len(list(set(phone_book)))) != len(list(phone_book)):
        return False
    
    phone_book.sort()

    for idx in range(len(phone_book)-1):
        if phone_book[idx+1].startswith(phone_book[idx]):
            return False
    return True
        

print(solution(["119", "97674223", "1195524421"]))
print(solution(["123","456","789"]))
print(solution(["12","123","1235","567","88"]))