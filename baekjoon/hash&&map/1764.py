import sys
input = sys.stdin.readline

N,M=map(int,input().split())
never_heard=[]
never_seen=[]
for _ in range(N):
    never_heard.append(input().rstrip())
for _ in range(M):
    never_seen.append(input().rstrip())

answer=sorted(list(set(never_heard) & set(never_seen)))

print(len(answer))
for i in answer:
    print(i)

