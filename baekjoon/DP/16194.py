import sys
input = sys.stdin.readline

N=int(input())
P=list(map(int,input().split()))
P.insert(0,0)

l=[[0]*(N+1) for _ in range(N+1)]

for j in range(1,N+1):
    l[1][j]=P[1]

for i in range(1,N+1):
    l[i][1] = P[1]*i


for i in range(2,N+1):
    for j in range(2,N+1):
        if i < j:
            l[i][j]=l[i][i]
        else:
            l[i][j] = min(l[i][j-1],l[i-j][j] + P[j])

print(l[N][N])
# print('------------')
# for i in range(N+1):
#     for j in range(N+1):
#         print(l[i][j],end=' ')
#     print('')




    
    



