import sys
input = sys.stdin.readline

N=int(input())
l=list()
for _ in range(N):
    [a,b]=input().split()
    l.append([int(a),b])

l.sort(key=lambda x:x[0])

for age,name in l:
    print(age,name)




