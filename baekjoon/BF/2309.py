import sys
import math
input = sys.stdin.readline

l=[]

for _ in range(9):
    l.append(int(input()))

sum_l=sum(l)
flag=0
for i in range(8):
    for j in range(i+1,9):
        tmp=l[i]+l[j]
        if((sum_l-tmp)==100):
            del l[i]
            del l[j-1]
            flag=1
            break
    if flag==1:
        break


l.sort()

for i in l:
    print(i)


