from collections import deque

N, M, Start = map(int, input().split())
A = [[] for _ in range(N + 1)]
for _ in range(M):
    s, e = map(int, input().split())
    A[s].append(e)  # 양방향 에지이므로 양쪽에 에지를 더하기
    A[e].append(s)
for i in range(N + 1):
    A[i].sort()  # 번호가 작은 노드 부터 방문하기 위해 정렬하기
visited = [False] * (N + 1)


def DFS(v):
    print(v, end=' ')
    visited[v] = True
    for i in A[v]:
        if not visited[i]:
            DFS(i)


DFS(Start)

visited = [False] * (N + 1)  # 리스트 초기화


def BFS(v):
    queue = deque() # 탐색경로
    queue.append(v) #맨 처음값 추가
    visited[v] = True #방문배열 바꿔주기
    while queue: # 큐가 비어있을때 까지지
        now_Node = queue.popleft() # queue에서 연결된 부분을 빼준다. 
        print(now_Node, end=' ')
        for i in A[now_Node]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
#5 5 3
# 5 4
# 5 2
# 1 2
# 3 4
# 3 1

# queue [3] visited[3]= ture-> now_Node =3 ,queue[] -> A[3] = [1,4] -> for i in [1,4] -> visited[1],visited[4] Ture visited =[3,1,4] ,queue= [1,4]
# while 문으로 queue.popleft queue = [4], now_Node =1, A[1] =[2,3] queue =[4,2] True visited[3,1,4,2] = True
# while 문으로 queue.popleft queue = [2]now_Node =4, A[4] =[3,5] queue =[2,5] True visited [3,1,4,2,5] =Ture
# while 문으로 now_ Node =2, while문으로 now_Node =5  Now_Node 값이 나올때마다 출력하면 3 1 4 2 5 가 나온다. 


print()
BFS(Start)