# 숫자의 합 구하기 백준 11720
n = input()
numbers = list(input())
sum = 0

for i in numbers: #하나의 요소요소를 불러온다.
    sum = sum + int(i)
print(sum)
