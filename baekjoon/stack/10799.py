from collections import deque
import sys

input = sys.stdin.readline

st=input().rstrip()

stck=[]
prev_i=None
answer=0
for i in st:
    if i=='(':
        stck.append('(')
    elif prev_i=='(' and i==')':
        stck.pop()
        answer+=len(stck)
    else:
        stck.pop()
        answer+=1
    prev_i=i
print(answer)
