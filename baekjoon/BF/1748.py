import sys
input = sys.stdin.readline

N=int(input())


N_length=len(str(N))

if N_length>1:
    cnt=9
    for i in range(2,N_length):
        cnt+=i*9*pow(10,i-1)
    
    cnt+=(N-pow(10,N_length-1)+1)*N_length
    print(cnt)
else:
    print(N)

        




        
    
            
