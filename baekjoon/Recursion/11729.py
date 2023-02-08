def hanoi(n,start,via,end):
    if n==1:
        print(start,end)
        return
    else:
        hanoi(n-1,start,end,via)
        print(start,end)
        hanoi(n-1,via,start,end)
        return

n = int(input())
print(2**n-1)
hanoi(n,1,2,3)

