import sys
import math
input = sys.stdin.readline

N, K=map(int,input().split())

dp=[[0]*(K+1) for _ in range(N+1)]

dp[1]=[i for i in range(K+1)]

for i in range(1,N+1):
    dp[i][1]=1
    if K>1:
        dp[i][2]=i+1

for i in range(2,N+1):  
    for j in range(3,K+1):
        dp[i][j]=dp[i-1][j]%1000000000+dp[i][j-1]%1000000000
    
print(dp[N][K]%1000000000)


