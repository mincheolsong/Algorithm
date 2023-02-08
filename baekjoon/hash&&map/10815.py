def binary_search(l,target):
    start=0
    end=len(l)-1
    while start<=end:
        mid = (start+end) // 2
        if target==l[mid]:
            return True
        elif target > l[mid]:
            start = mid+1
        elif target < l[mid]:
            end = mid-1
    return False

        
N=int(input())
own_card=list(map(int,input().split()))
M=int(input())
cards=list(map(int,input().split()))

own_card.sort()

for i in cards:
    if binary_search(own_card,i):
        print(1,end=' ')
    else:
        print(0,end=' ')




