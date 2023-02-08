import sys


N=int(sys.stdin.readline())
cnt=[0]*(10000+1)

for _ in range(N):
    cnt[int(sys.stdin.readline())]+=1

for i in range(10000+1):
        for _ in range(cnt[i]):
            print(i)


