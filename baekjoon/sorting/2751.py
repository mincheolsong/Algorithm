import sys


def merge_sort(l):
    n=len(l)

    if n<=1:
        return 
    
    mid=n//2
    left_list=l[:mid]
    right_list=l[mid:]

    merge_sort(left_list)
    merge_sort(right_list)
    
    i=j=0
    now=0
    while i<len(left_list) and j<len(right_list):
        if left_list[i]<right_list[j]:
            l[now]=left_list[i]
            now+=1
            i+=1
        else:
            l[now]=right_list[j]
            now+=1
            j+=1
    while i<len(left_list):
        l[now]=left_list[i]
        now+=1
        i+=1
    while j<len(right_list):
        l[now]=right_list[j]
        now+=1
        j+=1


N=int(sys.stdin.readline())
l=[]
for _ in range(N):
    l.append(int(sys.stdin.readline()))

merge_sort(l)
for i in l:
    print(i)

