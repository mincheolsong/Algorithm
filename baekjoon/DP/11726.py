import sys
input = sys.stdin.readline

n=int(input())

d=[0]*(n+1)


for i in range(1,n+1):
    if i<=2:
        d[i]=i
    else:
        d[i]=d[i-1]+d[i-2]

print(d[n]%10007)
    
    



