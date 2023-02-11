import sys
from collections import deque

input = sys.stdin.readline

N, L = map(int, input().split())
mydeque = deque()
now = list(map(int, input().split()))

for i in range(N):
    # 아이디어 1. 나보다 큰 데이터 삭제하기
    while mydeque and mydeque[-1][0] > now[i]: #내 덱에 제일 오른쪽 끝에있는 값이 현재 값보다 크면 while문을 돌면서 pop # mydeque 혼자 쓰면 비어있을경우 False반환
        mydeque.pop()
    mydeque.append((now[i],i)) #deque([(1,0)]) 숫자와 인덱스
    # 슬라이드 윈도우 벗어난 데이터 삭제하기
    if mydeque[0][1] <= i -L: # 윈도우 범위를 벗어나면
        mydeque.popleft()# 앞에서 뺀다.
    print(mydeque[0][0], end =" ") #한줄에 붙여서 출력


# deque
# Stack이나 queue처럼 한 방향에서 삽입과 삭제가 일어나는게 아니라 양방향에서 삽입과 삭제가 일어나는 자료구조이다.

#deque([(1,0),(5,1)]) deque[0][0] ->1 deque[0][1] ->0 deque[-1][0] :제일 오른쪽의 묶음의 첫번째 값 5