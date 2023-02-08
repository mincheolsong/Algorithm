import sys
from collections import Counter

N=int(sys.stdin.readline())
l=[]
for _ in range(N):
    l.append(int(sys.stdin.readline()))

cnt=[]

l.sort()

print(round(sum(l)/N))
print(l[N//2])

counter_l=Counter(l).most_common()
if len(counter_l)>1 and counter_l[0][1]==counter_l[1][1]:
    print(counter_l[1][0])
else:
    print(counter_l[0][0])

print(max(l)-min(l))