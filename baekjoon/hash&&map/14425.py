import sys
input = sys.stdin.readline

N,M = map(int,input().split())
s=set()
l=list()

for _ in range(N):
    s.add(input())
for _ in range(M):
    l.append(input())
cnt=0
for i in l:
    if i in s:
        cnt+=1

print(cnt)




