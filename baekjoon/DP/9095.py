import sys
input = sys.stdin.readline

T=int(input())

d=[0]*11

for i in range(1,11):
        if i==1:
            d[i]=1
        elif i==2:
            d[i]=2
        elif i==3:
            d[i]=4
        else:
            d[i]=d[i-1]+d[i-2]+d[i-3]

for _ in range(T):
    n=int(input())
    print(d[n])
    

    
    



