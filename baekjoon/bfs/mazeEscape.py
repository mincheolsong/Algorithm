# import sys
# input = sys.stdin.readline

from collections import Counter, deque
from math import sqrt

        
def solve():
    
    dx=[-1,0,1,0]
    dy=[0,1,0,-1]

    while queue:
        x,y=queue.popleft()

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<=nx<N and 0<=ny<M and maze[nx][ny]==1 and (nx+ny)!=0:
               
                maze[nx][ny]=maze[x][y]+1
                queue.append((nx,ny))
            


    return maze[-1][-1]

N,M=map(int,input().split())

maze=[list(map(int,input())) for _ in range(N)]
queue=deque()
queue.append((0,0))
solve()

for i in maze:
    for j in i:
        print('{:2d}'.format(j),end=' ')
    print()

