import sys

def solve():
    n, m = map(int, sys.stdin.readline().rstrip().split())
    arr = list(map(int, sys.stdin.readline().rstrip().split()))
    s = [0] # 첫번째 값은 똑같으므로 무시 sum 이지만 sum 메서드와 겹치므로 S로 표시
    for i in range(n):
        s.append(arr[i]+ s[i])
        #print(s)
    for _ in range(m):
        i,j = map(int, sys.stdin.readline().rstrip().split())
        print(s[j]- s[i-1])
solve()







# def solve():
#     n, m = map(int, sys.stdin.readline().rstrip().split())
#     arr = list(map(int, sys.stdin.readline().rstrip().split()))
    
#     for _ in range(m):
#         i,j = map(int, sys.stdin.readline().rstrip().split())
#         print(s(arr[i-1: j]))



# solve()

# 동시 수정 ctrl + shift +l
# sys.stdin.readline()  = input() jupyter notebook 이나 코랩은 안되므로 input을 써야한다.
# rstrip => 오른쪽 공백 제거