N = int(input())
A = [0]*N
for i in range(N):
    A[i] = int(input())
for i in range(N-1):
    for j in range(N-1-i):
        if A[j]>A[j+1]:
            temp = A[j]
            A[j] =A[j+1]
            A[j+1] =temp

for i in range(N):
    print(A[i])


# N = int(input())
# A = [0]*N
# for i in range(N):
#     A[i] = int(input())
# A.sort()
# for i  in range(N):
#     print(A[i])

#자바에서는 시간차이가 안났는데 파이썬에서는 sort() 매서드를 사용한게 더 빨랐다. 