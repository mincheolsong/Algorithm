import sys
input = sys.stdin.readline

def btk(n):
    if n==M:
        print(' '.join(map(str,answer)))
        return
    
    for i in range(1,N+1):
        answer.append(i)
        btk(n+1)
        answer.pop()

N,M = map(int,input().split())
answer=[]


btk(0)


