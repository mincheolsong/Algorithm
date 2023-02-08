import sys
input = sys.stdin.readline

n=int(input())
l=[]
stack=[0]

for _ in range(n):
    l.append(int(input()))
cnt=1
answer=[]
flag=1
for i in l:
    if stack[-1]<i:
        while(stack[-1]<i):
            stack.append(cnt)
            cnt+=1
            answer.append('+')
    if stack[-1]==i:
        stack.pop()
        answer.append('-')
    elif stack[-1]>i:
        print('NO')
        flag=0
        break

if flag!=0:
    print('\n'.join(answer))
