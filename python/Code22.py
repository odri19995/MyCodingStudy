import sys
dinput = sys.stdin.readline
N = int(input())
count = [0] * 10001
for i in range(N):
    count[int(input())] += 1
for i in range(10001):
    if count[i] != 0:
        for _ in range(count[i]):
            print(i)


# 늘 같이 쓸 수는 없다. 계수정렬을 사용해야 할 경우
# 데이터가 양수이고 데이터의 값의 크기가 작을 경우 이용하면 좋다.
# 데이터를 인덱스 취급해서 넣었다가 차례대로 빼주는 형식이다. 