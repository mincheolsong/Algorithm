from collections import deque, Counter
import sys

input = sys.stdin.readline

N=int(input())
a=list(map(int,input().split()))
count_a=Counter(a)
answer=[-1]*N
stck=[]

for i in range(N):
    while len(stck)>0 and count_a[stck[-1][0]] < count_a[a[i]]:
        val,idx=stck.pop()
        answer[idx]=a[i]
    
    stck.append([a[i],i])

print(*answer)
