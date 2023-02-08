# import sys
# input = sys.stdin.readline

def dp():
    
    for i in range(2,N+1):
        for j in range(1,K+1):
            if j-l[i-1]<0:
                answer[i][j]=answer[i-1][j]
            else:
                answer[i][j]=answer[i-1][j-l[i-1]]+answer[i-1][j]
            
            



T=int(input())

for i in range(T):
    N,K=map(int,input().split())
    l=list(map(int,input().split()))
    
    answer=[[0]*(K+1) for _ in range(N+1)]

    for p in range(N+1):
        answer[p][0]=1
    
    for p in range(1,K+1):
        if l[0]==p:
            answer[1][p]=1
    dp()
    print('#{} {}'.format((i+1),answer[-1][-1]))

   
