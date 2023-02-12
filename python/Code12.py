n =int(input())
ans = [0] * n # 정답 배열
A = list(map(int, input().split()))
myStack = []

for i in range(n):
    while myStack and A[myStack[-1]] < A[i] :# 현재 Stack의 꼭대기 값을 확인 # 오큰수 조건
        ans[myStack.pop()] = A[i] #빼주면서 정답 리스트에 오큰수로 저장
    myStack.append(i) #값이 아니라 인덱스를 저장한다.

while myStack:
    ans[myStack.pop()] = -1 

result = ""
for i in range(n) :
    result += str(ans[i])+ " "

print(result)


#인덱스를 넣어주는 것이 중요하다.