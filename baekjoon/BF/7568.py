N=int(input())
l=[]
for _ in range(N):
    l.append(tuple(map(int,input().split())))



for i in range(N):
    cnt=0
    for j in range(N):
        if i!=j and l[i][0]<l[j][0] and l[i][1]<l[j][1]:
            cnt+=1
    print(cnt+1,end=' ')



