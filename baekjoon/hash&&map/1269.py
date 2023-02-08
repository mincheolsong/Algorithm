import sys
input = sys.stdin.readline

_,_=map(int,input().split())
a=list(map(int,input().split()))
b=list(map(int,input().split()))


print(len(list(set(a)^set(b))))