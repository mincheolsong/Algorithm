import sys
input = sys.stdin.readline

def btk(n):
    if n==M:
        for i in range(1,M+1):
            print(answer[i],end=' ')
        print()
        return
    
    for i in range(1,len(l)):
        if chk[i]==False and answer[-1]<l[i]:
            chk[i]=True
            answer.append(l[i])
            btk(n+1)
            chk[i]=False
            answer.pop()

N,M = map(int,input().split())

l=list(map(int,input().split()))
l.insert(0,0)
l.sort()

chk=[False]*(N+1)
answer=[-1]

btk(0)


