n = int(input())
arr = [int(x) for x in input().split()] # int(x) 의미 : x 값을 int 형식으로 변환
#arr = list(map(int, input().split())) #리스트를 안씌워주면 값은 map 객체이다.
M = max(arr)
s = 0

for i in arr:
    s += ((i/M) * 100)
print(s/n)