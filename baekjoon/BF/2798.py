N,M=map(int,input().split())

l=list(map(int,input().split()))


gap=M
for i in range(0,N-2):
    for j in range(i+1,N-1):
        for k in range(j+1,N):
            tmp = l[i]+l[j]+l[k]
            if(tmp<=M and gap>M-tmp):
                gap=M-tmp
                answer=tmp


print(answer)