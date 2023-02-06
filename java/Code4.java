package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code4 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Inputstream(system.in(키보드))을 reader 객체로 만들어주고 BufferedReader 객체에 넣어주고 만들어서
		// bf에 저장한다.
		StringTokenizer st ;
		try {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int A[][] = new int[N+1][N+1];  // 실제 표의 (2,2) 는 이중배열의 (3,3)// 앞이 0으로 채워져도 잘 돌아간다. 
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int D[][] = new int[N + 1][N + 1];// 합배열도 크기는 같다.
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// 구간 합 구하기
					D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
				}
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				// 구간합 배열로 질의에 답변하기
				int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
				System.out.println(result);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
