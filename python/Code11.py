import sys

input = sys.stdin.readline

N = int(input()) #수열 개수
A =[] #수열 배열
for _  in range(N) : #수열 배열 입력
    A.append(int(input()))
num =1 #숫자 1부터 시작
result =True
stack = [] # 값을 넣어줄 스택 저장소
bf =[] #stringbuffer 같은 값 저장소

for i in range(len(A)) :
    su = A[i]
    if (su >=num) :
        while(su >=num): # 스택 넣기 push
            stack.append(num)
            bf.append("+")  
            num += 1
    # 스택 꺼내기 pop
        stack.pop()
        bf.append("-")
    else:
        n = stack.pop() #처음으로 빠지는 값 3은 su 3과 비교했을때 빼줄수 있으므로 - 값을  bf에 넣어준다. 
        if (n> su): #5,3 같이 빼줄수가 없는 경우
            print("NO")
            result = False
            break
        else :
            bf.append("-")

# 정답 출력
if result :
    for i in bf :
        print(i)







"""
N = int(input())
A =[0] *N

for i in range(N) :
    A[i] = int(input())


Java A.length =>python len(A)

파이썬에서는 값 추가는 append(), 값 삭제는  pop()  스택 문제에서는 따로 import할 필요는 없다. 
"""