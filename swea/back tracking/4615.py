# import sys
# input = sys.stdin.readline

from collections import deque


def show():
    for p in l:
        for q in p:
            print(q, end=' ')
        print()
    return


def check(r, c, r_direction, c_direction):
    global flag

    if not (0<= r + r_direction < N and 0<=c + c_direction < N):
        return False

    if flag == 1 and l[r + r_direction][c + c_direction] == color:
        return True

    if l[r + r_direction][c + c_direction] != color and l[r + r_direction][c + c_direction] != 0:
        flag = 1
        prev_col = l[r + r_direction][c + c_direction]
        l[r + r_direction][c + c_direction] = color
        if check(r + r_direction, c + c_direction, r_direction, c_direction):
            return True
        flag = 0
        l[r + r_direction][c + c_direction] = prev_col

    return False


T = int(input())

direction = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]

for i in range(T):
    N, M = map(int, input().split())
    l = [[0] * N for _ in range(N)]

    l[N // 2 - 1][N // 2 - 1] = l[N // 2][N // 2] = 2  # 백돌 : 2
    l[N // 2 - 1][N // 2] = l[N // 2][N // 2 - 1] = 1  # 흑돌 : 1

    for _ in range(M):
        col, row, color = map(int, input().split())
        l[row - 1][col - 1] = color
        for dr, dc in direction:
            flag = 0
            check(row - 1, col - 1, dr, dc)
        show()

    black=sum([p.count(1) for p in l])
    white=sum([p.count(2) for p in l])

    print('#{} {} {}'.format((i+1),black,white))
#
#
#
# l=[[1,2,3],[1,2,4],[1,2,5]]
# one=sum([i.count(5) for i in l])
#
# print(one)