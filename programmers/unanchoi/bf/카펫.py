
def solution(word: str):
    
    def loop(word: str):
        for i in range(len(word)-1):
            if word[0] == word[1]:
                word = word[2:]
            else:
                word = word[1:] + word[0]
        return word
    
    result = word
    while True:
        tmp = result
        if result == "":
            return 1
        else:
            result = loop(word)

        if tmp == result:
            break
    return 0