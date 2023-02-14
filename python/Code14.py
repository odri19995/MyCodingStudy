import sys
import heapq

n = int(input())
heap = []
for i in range(n):
    x = int(sys.stdin.readline())
    if x == 0:
        if heap:
            print(heapq.heappop(heap)[1]) #heap에서 빼준거의 x값 즉 원본값 반환
        else:
            print(0)
    else:
        heapq.heappush(heap,(abs(x),x)) #절댓값과 원본값을 같이 저장



# heapq  모듈은 파이썬의 리스트를 마치 최소 힙 처럼 다룰수 있게 해줍니다. 
#최대 힙으로 바꾸려면 abs(x)값앞에 - 값을 붙이면 됩니다. 