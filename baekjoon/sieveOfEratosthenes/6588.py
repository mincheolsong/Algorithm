from collections import deque, Counter
from string import ascii_lowercase
import sys
import math

input = sys.stdin.readline

arr=[True]*1000001

for i in range(2,int(math.sqrt(1000001))+1):
    if arr[i]:
        for j in range(i+i,1000001,i):
            arr[j]=False

while True:
    n=int(input())
    flag=0
    if n==0:
        break
    
    for i in range(3,n//2+1):
        if arr[i]==True and arr[n-i]==True:
            print('%d = %d + %d'%(n,i,n-i))
            flag=1
            break

    if flag==0:
        print("Goldbach's conjecture is wrong.")

        
