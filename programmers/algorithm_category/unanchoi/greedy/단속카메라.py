def solution(routes):
    routes.sort(key=lambda x: x[1]) 
    cameras = 0
    
    last_camera = -30001 

    for route in routes:
        if route[0] > last_camera:
            cameras += 1
            last_camera = route[1]

    return cameras