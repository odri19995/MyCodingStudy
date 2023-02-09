# N,M = map(int, input().split())
N = int(input())
M = int(input())
A = list(map(int, input().split()))
A.sort()
count =0
i, j = 0,N-1
while i < j:
    if A[i]+A[j] <M :
        i +=1
    elif A[i]+A[j] >M :
        j -=1
    else :
        i +=1 
        j-=1
        count +=1
print(count)
