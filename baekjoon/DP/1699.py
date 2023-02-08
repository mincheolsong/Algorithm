import sys
import math
input = sys.stdin.readline

N=int(input())

dp=[0]*(N+1)

for i in range(1,int(math.sqrt(N))+1):
  dp[i**2] = 1

for i in range(2,N+1):
  if dp[i]==0:
    min_dp=dp[i-1]
    for k in range(int(math.sqrt(i))-1,0,-1):
      if dp[i-k**2] < min_dp:
        min_dp=dp[i-k**2]
        if min_dp==1:
          break
    dp[i]=min_dp+1

print(dp[N])