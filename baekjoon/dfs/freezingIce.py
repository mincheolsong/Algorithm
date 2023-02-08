# import sys
# input = sys.stdin.readline

def dfs(i,j):
    dx=[0,1,0,-1]
    dy=[1,0,-1,0]

    for p in range(4):
        tmp_x=i+dx[p]
        tmp_y=j+dy[p]
        if 0<=tmp_x<N and 0<=tmp_y<M and maze[tmp_x][tmp_y]==0:
            maze[tmp_x][tmp_y]='x'
            dfs(tmp_x,tmp_y)

    return


def solve():
    answer=0
    for i in range(N):
        for j in range(M):
            if maze[i][j]==0:
                maze[i][j]='x'
                answer+=1
                dfs(i,j)

    return answer


N,M=map(int,input().split())

maze=[list(map(int,input())) for _ in range(N)]


print(solve())


for i in maze:
    for j in i:
        print(j,end=' ')
    print()