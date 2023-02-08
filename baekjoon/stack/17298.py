import sys

input = sys.stdin.readline

N=int(input())
a=list(map(int,input().split()))
answer=[-1]*N
stck=[]

for i in range(N):
    while len(stck)>0 and stck[-1][0] < a[i]:
        val,idx=stck.pop()
        answer[idx]=a[i]
    
    stck.append([a[i],i])

print(*answer)