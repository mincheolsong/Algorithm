import sys
input = sys.stdin.readline


def solve(M,N,x,y):
    i=0

    while x+M*i<=M*N:
        if (x+M*i-y)%N==0:
            return x+M*i
        i+=1
            
    return -1

T=int(input())


for _ in range(T):
    M,N,x,y = map(int,input().split())

    print(solve(M,N,x,y))








        




        
    
            
