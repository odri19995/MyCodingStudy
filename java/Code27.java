import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code27 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 }; // {아래 ,오른쪽 ,위 , 왼쪽 }
	static boolean[][] visited;
	static int[][] A;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine()); // 공백이 없을때 nextToken을 쓰기 쉽지 않다.
			String line = st.nextToken();// 일단 한줄로 쭉 받는다. //101111
			for(int j =0; j < M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}
		BFS(0,0); //시작점
		System.out.println(A[N-1][M-1]);
		
	}

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j}); // queue 에 data를 넣어준다. 처음 시작점은 {0,0} 이 들어간다. 
		visited[i][j] = true;
		while(!queue.isEmpty()) { // 큐가 빌때까지
			int now[] = queue.poll();
			for(int k = 0; k<4; k++) {// 상하 좌우로 탐색
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x>= 0 && y >= 0 && x <N && y <M) { // 배열을 넘어가면 안됨
					if(A[x][y]!= 0 && !visited[x][y]) { //0이어서 갈수 없는 곳이거나 , 이제 갈수 없는곳이다.
						visited[x][y] = true; 
						A[x][y] = A[now[0]][now[1]] +1; // 깊이 업데이트하기
						queue.add(new int[] {x,y}); // 새로운 x, y 를 넣어준다.
						
					}
				}
				
			}
			
			
		}
	}

}
