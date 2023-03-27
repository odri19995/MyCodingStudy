import java.util.*;
public class Code28 {
  static boolean visited[];
  static int [] distance;
  static ArrayList<Edge>[] A;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 노드의 개수
    A = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      A[i] = new ArrayList<Edge>();
    }
    for (int i = 0; i < N; i++) { // A 인접 리스트에 그래프 데이터 저장하기
      int S = sc.nextInt();  //시작점
      while(true)
      {
        int E = sc.nextInt(); // 노드 
        if(E==-1)break;
        int V = sc.nextInt(); // 거리값
        A[S].add(new Edge(E, V)); //A[3] = [[1,2][4,3]]
      }
    }
    distance = new int[N+1]; // 거리 배열 초기화
    visited = new boolean[N+1]; //방문 배열
    BFS(1); //임의의 노드에서 시작
    int Max = 1;
    for(int i=2; i<=N; i++) {
      if(distance[Max]<distance[i])
        Max = i;  // 임의의 노드에서 가장 긴 경로로 연결되어 있는 노드는 트리의 지름에 해당하는 두 노드중 하나이다.
    }
    distance = new int[N+1]; //거리 배열 초기화
    visited = new boolean[N+1];
    BFS(Max); //트리의 지름에 해당하는 노드중 하나로 BFS실행
    Arrays.sort(distance);
    System.out.println(distance[N]);
  }

  private static void BFS(int index) {  // BFS구현
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(index);
    visited[index] = true;
    while (!queue.isEmpty()) {
      int now_node = queue.poll();
      for (Edge i : A[now_node]) {
        int e = i.e;
        int v = i.value;
        if (!visited[e]) {
          visited[e] = true;
          queue.add(e);
          distance[e]=distance[now_node]+v;
        }
      }
    }
  }
}
class Edge {
  int e;
  int value;

  public Edge(int e, int value) {
      this.e = e ;
      this.value = value;
  }
}