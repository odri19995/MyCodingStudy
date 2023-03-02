import java.util.ArrayList;
import java.util.Scanner;

public class Code25 {
	static boolean visited[]; // 방문 배열
	static ArrayList<Integer>[] A; // 인접 리스트 인덱스를 버리고 빈틈없는 데이터의 적재
	static boolean arrive;

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int N; // 노드 개수
		int M; // 에지 개수
		arrive = false;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt(); // scanner 구분은 공백이나 엔터
		A = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) { // 정수 a,b가 0부터 N-1까지 0도 포함
			A[i] = new ArrayList<Integer>(); // A[0] = [연결된 정수들] 리스트 안의 리스트 개념
		}
		for (int i = 0; i < M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
			A[E].add(S);
		}
		for (int i = 0; i < N; i++) {
			DFS(i, 1);
			if (arrive)
				break;
		}
		if (arrive)
			System.out.println("1");
		else
			System.out.println("0"); // 5의 깊이가 없다면 0 출력
		sc.close();
	}

	public static void DFS(int now, int depth) { // DFS구현
		if (depth == 5 || arrive) { // 깊이가 5가되면 프로그램 종료
			arrive = true;
			return;
		}
		visited[now] = true;
		for (int i : A[now]) {
			if (!visited[i]) {
				DFS(i, depth + 1);
			}
		}
		visited[now] = false;
	}
}
