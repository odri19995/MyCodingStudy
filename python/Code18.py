N = int(input())
A = list(map(int,input().split(" ")))
S =[0] #나중에 덮어씌어질 초기값 S[0]=0을 넣어준다. 
for i in range(1,N):
    insert_point =i 
    insert_value =A[i]
    for j in range (i-1,-1,-1) : # 증가폭 -1 i-1 부터 -1 까지
        if A[j]<A[i] :
            insert_point = j +1 # (3,4) 부분 A[1]<A[2]  =3<4 순서 가 맞을때  삽입 위치를 하나 더해준다.
            break
        if j==0:
            insert_point = 0
    for j in range (i,insert_point,-1):
        A[j] =A[j-1]
    A[insert_point] =insert_value
S[0] =A[0] #S=[0] ->s=[1]
for i in range(1,N): # 합배열 만들기
    S.append(A[i] +S[i-1])
sum = 0
for i in range(N):
    sum += S[i]
print(sum)

# A = [3,1,4,3,2] -> [3,3,4,3,2] ->[1,3,4,3,2]
