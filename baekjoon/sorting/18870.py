import sys
input = sys.stdin.readline

N=int(input())
l=list(map(int,input().split()))

l_component=sorted(list(set(l)))

l_dict={l_component[i]:i for i in range(len(l_component))}

for i in l:
    print(l_dict[i])





