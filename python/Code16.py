import sys

N = int(input())

nums = []

for i in range(N):
    num = int(sys.stdin.readline())
    nums.append((num, i))
    
sorted_nums = sorted(nums)

answer = 0
for i in range(N):
    answer = max(sorted_nums[i][1] - i + 1, answer)
    
print(answer)

# 자바에서는 값과 인덱스를 저장하는 방법이 새로운 클래스를 선언하고 Comparable 인터페이스를 상속했는데