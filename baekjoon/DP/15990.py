import sys
input = sys.stdin.readline

T=int(input())

l=[[0]*(4) for _ in range(100000+1)]

l[1][1]=l[2][2]=1

l[3]=[0,1,1,1]

for i in range(4,100000+1):
    for j in range(1,4):
      if j==1:
        l[i][j]=l[i-1][3]%1000000009+l[i-1][2]%1000000009
      elif j==2:
        l[i][j]=l[i-2][3]%1000000009+l[i-2][1]%1000000009
      else:
        l[i][j]=l[i-3][2]%1000000009+l[i-3][1]%1000000009


for _ in range(T):
  n=int(input())
  print((l[n][1]+l[n][2]+l[n][3])%1000000009)