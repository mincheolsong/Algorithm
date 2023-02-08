N=int(input())
l=list()
for _ in range(N):
    l.append(tuple(map(int,input().split())))

l.sort()
for a,b in l:
    print(a,b)