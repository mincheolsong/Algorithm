import sys
input = sys.stdin.readline

def btk(n):
    if n==M:
        for i in range(1,M+1):
            print(answer[i],end=' ')
        print()
        return
    
    for i in range(1,N+1):
        if i>=answer[-1]:
            answer.append(i)
            btk(n+1)
            answer.pop()

N,M = map(int,input().split())
answer=[-1]


btk(0)


