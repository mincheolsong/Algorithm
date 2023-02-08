import sys
input = sys.stdin.readline

N,M = map(int,input().split())


chk = [False]*(N+1)

answer=[]

def backTracking(num):
    
    if num==M:
        print(' '.join(map(str,answer)))
        return
    
    for i in range(1,N+1):
        if chk[i]==False:
            chk[i]=True
            answer.append(i)
            backTracking(num+1)
            answer.pop()
            chk[i]=False

backTracking(0)