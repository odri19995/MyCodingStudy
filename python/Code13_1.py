N= int(input())
myQue = []

for i in range(1,N+1): #시간 복잡도 N
    myQue.append(i)
myQue.reverse() # 리스트를 뒤집었다. 시간 복잡도 N


while (len(myQue)>1) :
    newQue=[] # newQue 초기화
    myQue.pop() #시간 복잡도 1
    temp = myQue[-1] #시간 복잡도 1
    myQue.pop() #시간 복잡도 1
    newQue.append(temp) #시간 복잡도 1
    newQue.extend(myQue) #시간 복잡도 O(len)  
    myQue=list(newQue) #리스트를 복사할때는 같은 변수를 참조하기 때문에 리스트를 재선언해주었다. 
    #이 밖에도  myQue=newQue[:] 슬라이싱 ,myQue = newQue.copy() copy ,   myQue= [] + newQue 방법이 있다.

print(myQue[0])
# 이 방법은 시간초과에 걸렸다.
#아마 여기서 N *N 되어서 시간복잡도가 늘어난 듯 싶다. 다른 방법이 필요하다. 
# 보통 deque를 import 한다고 한다. 
# from collections import deque  