def solution(brown, yellow):
    answer = []
    total_tiles = brown + yellow

    for i in range(1, int((total_tiles)**(1/2))+4 ):
        if float(total_tiles // i) * i  == float(total_tiles):

            if (i-2)* 2 + (int(total_tiles/i)-2) * 2  == brown - 4:
                if (i - 2) * (int(total_tiles/i)-2) == yellow:
                    answer.append(int(total_tiles / i))
                    answer.append(i)
                    break 
    return answer