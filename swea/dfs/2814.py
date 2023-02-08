# import sys
# input = sys.stdin.readline


def dfs(i):
    global cnt

    visited[i]=True
    #print(i)
    cnt+=1
    flag=1

    for p in graph[i]:
        if visited[p]==False:
            flag=0
            dfs(p)
            visited[p]=False
            cnt-=1
            

    if flag==1:
        answer.append(cnt)
        # print(i,'is end node,',cnt)
        

    return


T=int(input())

for i in range(T):
    N,M=map(int,input().split())
    graph=[list() for _ in range(N+1)]
    l=[]
    answer=[]
    
    for _ in range(M):
        l.append(list(map(int,input().split())))
    
    for j in l:
        graph[j[0]].append(j[1])
        graph[j[1]].append(j[0])
    
    for j in range(1,N+1):
        visited=[False]*(N+1)
        cnt=0
        dfs(j)
    
    print('#{} {}'.format((i+1),max(answer)))
    
    
