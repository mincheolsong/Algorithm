# import sys
# input = sys.stdin.readline

def dp():
    for p in range(2,N+1):
        for q in range(1,L+1):
            if q-l[p-1][1]>=0:
                answer[p][q]=max(answer[p-1][q],answer[p-1][q-l[p-1][1]]+l[p-1][0])
            else:
                answer[p][q]=answer[p-1][q]
    return

T=int(input())

for i in range(T):

    N,L=map(int,input().split())
    l=[]
    answer=[[0]*(L+1) for _ in range(N+1)]

    for _ in range(N):
        l.append(tuple(map(int,input().split())))

    for j in range(1,L+1):
        if l[0][1]<=j:
            answer[1][j]=l[0][0]
        else:
            answer[1][j]=0
    
    dp()
    
    print('#{} {}'.format((i+1),answer[N][L]))

