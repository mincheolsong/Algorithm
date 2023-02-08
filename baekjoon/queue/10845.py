from collections import deque
import sys
input = sys.stdin.readline

n=int(input())

queue=deque()
size=0
for _ in range(n):
    cmd=input().split()
    if cmd[0]=='push':
        if size==0:
            front=cmd[1]
    
        queue.append(cmd[1])
        size+=1
        back=cmd[1]
    elif cmd[0]=='pop':
        if size>0:
            print(queue.popleft())
            size-=1
        else:
            print(-1)
    elif cmd[0]=='size':
        print(size)
    elif cmd[0]=='empty':
        if size==0:
            print(1)
        else:
            print(0)
    elif cmd[0]=='front':
        if size>0:
            front=queue.popleft()
            print(front)
            queue.appendleft(front)
        else:
            print(-1)
    elif cmd[0]=='back':
        if size>0:
            back=queue.pop()
            print(back)
            queue.append(back)
        else:
            print(-1)