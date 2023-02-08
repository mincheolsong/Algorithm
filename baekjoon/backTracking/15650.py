import sys
input = sys.stdin.readline

N,M = map(int,input().split())
chk=[False]*(N+1)
answer=[-1]


def btk(n):
    if n==M:
        for i in range(1,M+1):
            print(answer[i],end=' ')
        print()
        return
    
    for i in range(1,N+1):
        if chk[i]==False and answer[-1]<i :
            chk[i]=True
            answer.append(i)
            btk(n+1)
            chk[i]=False
            answer.pop()


btk(0)