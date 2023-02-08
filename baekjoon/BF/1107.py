import sys
import math
input = sys.stdin.readline

N=int(input())
M=int(input())

if M>0:
    err_btn=list(map(int,input().split()))
else:
    err_btn=[]

min_input=abs(100-N)

for num in range(999901):
    flag=1
    num = str(num)
    
    for i in num:
        if int(i) in err_btn:
            flag=0
            break
    
    if flag==1:
        min_input=min(min_input,abs(int(num)-N)+len(num))

print(min_input)



        




        
    
            
