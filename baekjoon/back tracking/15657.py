import sys
input = sys.stdin.readline

def btk(n):
    if n==M:
        for i in range(1,len(answer)):
            print(answer[i],end=' ')
        print()
        return
    
    for i in range(len(l)):
        if l[i]>=answer[-1]:
            answer.append(l[i])
            btk(n+1)
            answer.pop()

N,M = map(int,input().split())

l=list(map(int,input().split()))
l.sort()

answer=[-1]

btk(0)


