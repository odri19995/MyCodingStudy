import sys
input = sys.stdin.readline
print = sys.stdout.write

def merge_sort(s, e):
    if e - s < 1: return
    m = int(s + (e - s) / 2)
    merge_sort(s, m) # 분할 부분 재귀함수를 나오면서 한개의 요소로 잘라진다. 그 후 작은 부분끼리 비교를해서 순서에 맞춰 병합된다.
    merge_sort(m + 1, e)
    for i in range(s, e + 1):
        tmp[i] = A[i]
    k = s  ##정렬 부분
    index1 = s
    index2 = m + 1 #중간 다음값
    while index1 <= m and index2 <= e:
        if tmp[index1] > tmp[index2]:
            A[k] = tmp[index2]
            k += 1
            index2 += 1
        else:
            A[k] = tmp[index1]
            k += 1
            index1 += 1
    while index1 <= m:
        A[k] = tmp[index1]
        k += 1
        index1 += 1
    while index2 <= e:
        A[k] = tmp[index2]
        k += 1
        index2 += 1

N = int(input())
A = [0] * int(N + 1)
tmp = [0] * int(N + 1)
for i in range(1, N + 1):
    A[i] = int(input())
merge_sort(1, N)
for i in range(1, N + 1):
    print(str(A[i]) + '\n')