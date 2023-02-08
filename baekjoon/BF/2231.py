N=int(input())

answer=0
if len(str(N))>1:
    for i in range(10**(len(str(N))-2),N):
        l=list(map(int,str(i)))
        if i+sum(l)==N:
            answer=i
            break
else:
    for i in range(1,N):
        if i+i==N:
            answer=i

print(answer)
    


