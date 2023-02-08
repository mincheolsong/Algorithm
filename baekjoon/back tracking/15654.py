import sys
input = sys.stdin.readline

def btk(n):
    if n==M:
        print(' '.join(map(str,answer)))
        return
    
    for i in range(1,len(l)):
        if chk[i]==False:
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
answer=[]

btk(0)


