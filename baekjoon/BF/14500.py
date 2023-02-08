import sys
import math
input = sys.stdin.readline

N,M = map(int,input().split())
paper=[list(map(int,input().split())) for _ in range(N)]

tetros=[
    [[1,1,1,1]],
    [[1],[1],[1],[1]],
    [[1,1],[1,1]],
    [[1,0],[1,0],[1,1]],
    [[1,1,1],[1,0,0]],
    [[1,1],[0,1],[0,1]],
    [[0,0,1],[1,1,1]],
    [[0,1],[0,1],[1,1]],
    [[1,1,1],[0,0,1]],
    [[1,1],[1,0],[1,0]],
    [[1,0,0],[1,1,1]],
    [[1,0],[1,1],[0,1]],
    [[0,1,1],[1,1,0]],
    [[0,1],[1,1],[1,0]],
    [[1,1,0],[0,1,1]],
    [[1,1,1],[0,1,0]],
    [[0,1],[1,1],[0,1]],
    [[0,1,0],[1,1,1]],
    [[1,0],[1,1],[1,0]]
]

def calc(t,i,j,paper):
    h,w = len(t),len(t[0])

    result=0

    for p in range(h):
        for q in range(w):
            result+=t[p][q]*paper[i+p][j+q]

    return result

def place(t,n,m,paper):
    h,w = len(t),len(t[0])
    result=0

    for i in range(n-h+1):
        for j in range(m-w+1):
            tmp=calc(t,i,j,paper)
            if tmp>result:
                result=tmp
    
    return result


max_tetro=0

for tetro in tetros:
    tmp=place(tetro,N,M,paper)
    if max_tetro < tmp:
        max_tetro=tmp

print(max_tetro)




        




        
    
            
