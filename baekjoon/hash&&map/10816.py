import sys
input = sys.stdin.readline

N=int(input())
cards=sorted(map(int,input().split()))
M=int(input())
my_cards=list(map(int,input().split()))

cards_count={}

for i in cards:
    if i not in cards_count:
        cards_count[i]=1
    else:
        cards_count[i]+=1

for i in my_cards:
    answer=cards_count.get(i)
    if answer==None:
        print(int(0),end=' ')
    else:
        print(answer,end=' ')

