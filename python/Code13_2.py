from collections import deque

n = int(input())
myQue =deque()

for i in range (1,n+1):
    myQue.append(i)

while len(myQue) != 1:
    myQue.popleft()
    move_num = myQue.popleft()
    myQue.append(move_num)

print(myQue[0])




# n = deque(range(1, int(input())+1,))
# while len(n) != 1:
#     n.popleft()
#     n.rotate(-1)
# print(n[0])

#놀랍게도 짧다.. deque의 rotate를 활용하면 따로 저장하지 않아도 된다.