import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline
n, m = map(int, input().split())
A = [[] for _ in range(n+1)]
visited = [False] * (n+1)

def DFS(v):
    visited[v] = True
    for i in A[v]:
        if not visited[i]:
            DFS(i)

for _ in range(m):
    s, e = map(int, input().split())
    A[s].append(e)  # 양방향 에지이므로 양쪽에 에지를 더하기
    A[e].append(s)
count = 0
for i in range(1, n+1):
    if not visited[i]:  # 연결 노드 중 방문하지 않았던 노드만 탐색
        count += 1
        DFS(i)
print(count)

#파이썬으로 재귀를 사용해 문제를 풀 때 특히, DFS, BFS 문제를 풀 때 예시에서 답은 잘 나오는데,
#  정답 제출을 하면 런타임 에러를 접하게 되는 경우가 있습니다.
#대부분이 파이썬의 재귀 최대 깊이의 기본 설정이 1,000회 이기 때문에 런타임 에러가 발생하는 경우입니다.
#이런 문제를 해결하기 위해서는 아래와 같이 코드를 작성해주면 됩니다.
#sys.setrecursionlimit(10 ** 6)

#A =[[],[2,5],[1,5],[4],[3,6],[1,2],[4]]
# 첫번째 재귀 visited :[False, True , True, False, False, True, False]
# 두번째 재귀 visited :[False, True , True, True, True, True, True]