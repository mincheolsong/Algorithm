import sys
input = sys.stdin.readline

N=int(input())

l=[[0]*10 for _ in range(101)]

l[1]=[0,1,1,1,1,1,1,1,1,1]

for i in range(2,101):
  for j in range(0,10):
    if j==0:
      l[i][j]=l[i-1][1]%1000000000
    elif j==9:
      l[i][j]=l[i-1][8]%1000000000
    else:
      l[i][j]=l[i-1][j-1]%1000000000+l[i-1][j+1]%1000000000

print(sum(l[N])%1000000000)
