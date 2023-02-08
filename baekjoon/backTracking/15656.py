import sys
input = sys.stdin.readline

def btk(n):
    if n==M:
        print(' '.join(map(str,answer)))
        return
    
    for i in range(len(l)):
        answer.append(l[i])
        btk(n+1)
        answer.pop()

N,M = map(int,input().split())

l=list(map(int,input().split()))
l.sort()

answer=[]

btk(0)


