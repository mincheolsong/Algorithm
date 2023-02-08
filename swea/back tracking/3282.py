# import sys
# input = sys.stdin.readline


def dp():
    for i in range(2, N + 1):
        for j in range(1, K + 1):
            if j - l[i][0] >= 0:
                answer[i][j] = max(answer[i - 1][j], answer[i - 1][j - l[i][0]] + l[i][1])
            else:
                answer[i][j] = answer[i - 1][j]
    return


T = int(input())

for i in range(T):
    N, K = map(int, input().split())
    l = [[0, 0]]
    answer = [[0] * (K + 1) for _ in range(N + 1)]

    for _ in range(N):
        l.append(list(map(int, input().split())))

    for p in range(1, K + 1):
        if l[1][0] <= p:
            answer[1][p] = l[1][1]

    dp()

    print('#{} {}'.format((i+1),answer[-1][-1]))

