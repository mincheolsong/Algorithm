# import sys
# input = sys.stdin.readline

from collections import deque
from itertools import combinations
import math

T = int(input())

for i in range(T):
    n, m = map(int, input().split())

    park = [p for p in range(n - 1, -1, -1)]  # 주차 빈자리(오름차순)
    park_val = []  # 주차 가격

    cars_weight = []  # 차량 무게
    cars_history = [-1] * m  # 차량의 주차기록

    wait = deque()

    answer = 0

    for _ in range(n):
        park_val.append(int(input()))

    for _ in range(m):
        cars_weight.append(int(input()))

    for _ in range(2 * m):
        command = int(input())

        if command > 0:  # 차 넣음
            if len(park) <= 0:  # 공간 없음
                wait.append(command - 1)
            else:  # 공간 있으면 가장 작은 숫자의 자리에 차를 주차하면 됨
                cars_history[command - 1] = park.pop()
        else:  # 차 뺌
            park.append(cars_history[-command - 1])
            park.sort(reverse=True)
            if len(wait) > 0:  # 기다리는 차 있으면 새로 생긴 자리에 주차
                cars_history[wait.popleft()] = park.pop()

    for j in range(m):
        answer += cars_weight[j] * park_val[cars_history[j]]

    print('#{} {}'.format((i + 1), answer))
