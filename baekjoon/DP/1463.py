import sys
input = sys.stdin.readline

N=int(input())

d=[0]*(N+1)


for i in range(1,N+1):
    if i==1:
        d[i]=0
    elif i==2:
        d[i]=1
    else:
        d[i] = 1 + d[i-1]
        if i%3==0 and d[i]>1+d[i//3]:
            d[i]=1+d[i//3]
        if i%2==0 and d[i]>1+d[i//2]:
            d[i]=1+d[i//2]

print(d[N])
    
    



