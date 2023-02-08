import sys
import math
input = sys.stdin.readline

E,S,M=map(int,input().split())

while True:
    if E==S==M:
        print(E)
        break
    
    max_day=max(E,S,M)

    if E<max_day:
        E+=15
    if S<max_day:
        S+=28
    if M<max_day:
        M+=19

    


        

