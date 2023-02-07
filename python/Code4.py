import sys
input = sys.stdin.readline

n, m = map(int, input().split())
A = [[0]*(n+1)] #0 으로 채워진 배열 [[0, 0, 0]] n =2 일때 
D = [[0]*(n+1) for _ in range(n+1)] #이차원 배열 선언 [[0, 0, 0], [0, 0, 0], [0, 0, 0]] n =2

for i in range(n):
    A_row = [0]+ [int(x) for x in input().split()] # 형식지정과 for문(x를 int형으로 반환) 1 2 입력시 [0,1,2] 3 4 입력시 [0,3,4] 
    A.append(A_row) # 한줄 씩 원래 배열 A에 넣어준다. 

for i in range(1, n+1): 
    for j in range(1, n+1):
        D[i][j] = D[i][j-1] + D[i-1][j] -D[i-1][j-1] + A[i][j]

for _ in range(m):
    x1, y1, x2, y2 = map (int, input().split())
    result = D[x2][y2] - D[x1-1][y2] -D[x2][y1-1] + D[x1-1][y1-1]
    print(result)

# 디버깅 메모 :구간 건너뛰기 F5  한줄씩은 F10