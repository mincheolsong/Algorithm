import sys
input = sys.stdin.readline

N=int(input())

A=list(map(int,input().split()))

dp=[0]*N
dp[0]=1

for i in range(1,N):
  for j in range(0,i):
    if A[j]<A[i] and dp[j]>dp[i]:
      dp[i]=dp[j]
  dp[i]+=1

print(max(dp))

idx=N-1
l=[]
for i in range(max(dp),0,-1):
  for j in range(idx,-1,-1):
    if dp[j]==i:
      idx=j-1
      l.append(A[j])
      break

l.reverse()
for i in l:
  print(i,end=' ')


	

	


	
    

