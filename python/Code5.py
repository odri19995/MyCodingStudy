# import sys
# input = sys.stdin.readline
n, m = map(int, input().split())
A = list(map(int, input().split()))
S = [0] *n
C = [0] *m 
answer = 0

S[0] = A[0] #합 배열 생성 
for i in range(1,n):
    S[i] = S[i-1] + A[i]

for i in range(n):  # 재정의 합배열 [나머지 0의수, 나머지 1의 수, 나머지 2의 수]
    remainder = S[i] % m
    if remainder == 0:
        answer += 1 # 합이 나누어 떨어지는 합배열 [1,3,6,7,9] 중 [3,6,9] +3
    C[remainder] += 1 # 같은 값이 몇개인지 저장해주는 리스트

for i in range(m):
    if C[i] > 1:  
        answer += (C[i] *(C[i]-1) //2) #combination C 3C2(0) +2C2(2)

print(answer)

