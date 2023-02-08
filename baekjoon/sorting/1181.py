import sys
input = sys.stdin.readline

N=int(input())
l=list()
for _ in range(N):
    l.append(input().rstrip())

l=sorted(list(set(l)))

l.sort(key=lambda x:len(x))

for i in l:
    print(i)




