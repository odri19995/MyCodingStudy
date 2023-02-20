import sys

input = sys.stdin.readline
N, K = map(int, input().split())
A = list(map(int, input().split()))


def quickSort(S, E, K):
    global A
    if S < E:
        pivot = partition(S, E)
        if pivot == K:  # K번째 수가 pivot이면 더이상 구할 필요 없음
            return
        elif K < pivot:  # K가 pivot보다 작으면 왼쪽 그룹만 정렬
            quickSort(S, pivot - 1, K)
        else:  # K가 pivot보다 크면 오른쪽 그룹만 정렬
            quickSort(pivot + 1, E, K)


def swap(i, j):
    global A
    temp = A[i]
    A[i] = A[j]
    A[j] = temp


def partition(S, E):
    global A

    if S + 1 == E:
        if A[S] > A[E]:
            swap(S, E)
        return E

    M = (S + E) // 2
    swap(S, M)
    pivot = A[S]
    i = S + 1
    j = E
    while i <= j:
        while j >= S and pivot < A[j]:
            j = j - 1
        while  i <= E and pivot > A[i] :
            i = i + 1
        if i < j:
            swap(i, j)
            i = i + 1
            j = j - 1
        else:
            break
    # i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
    A[S] = A[j]
    A[j] = pivot
    return j


quickSort(0, N - 1, K - 1)
print(A[K - 1])

# global A 라는 것은 A라는 전역변수를 사용하는 문법이다. 수 안에서 global을 붙여도 되고, 함수 밖에서 global을 붙여도 된다. 하지만 함수 밖에서 선언하였다면 함수 안에서 사용을 명시해주어야 한다.
# 전체 코드에서 체크해야 하는 값이 있을 때 전역변수를 사용하면 편리하다.
# 특히 함수가 있는 코드를 실행하거나 수정할 때, 에러가 발생하거나 값이 안 맞으면 확인하기가 곤란하다.
#  이럴 때 함수 안의 변수를 전역변수로 선언하면, 코드를 실행하며 함수 안의 값들을 체크할 수 있기 때문에 유용하다. 프로그램을 디버깅할 때 편리한 방법인 듯 하다.
# 여기서는 변수 입력받는 변수하나를 줄여주는 역할을 했다. 원래라면 quicksort 안에 들어가는 매개변수는 리스트 A를 추가한 4개가 됬어야 한다. 