import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code8 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int Result = 0;
		long A[] = new long[N]; // int 말고 long 타입으로 받아준다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken()); // A가 long 타입이므로 한번더 변환해줘야한다. nextToken의 반환은 String
		}
		Arrays.sort(A);
		for (int k = 0; k < N; k++) {
			long find = A[k];
			int i = 0;
			int j = N - 1;
			// 투 포인터 알고리즘
			while (i < j) {
				if (A[i] + A[j] == find) {
					if (i != k && j != k) { // 0과 5의 반례 0과 5가 있어도 자기자신을 포함하고 있어서 5는 좋은수가 아니다.
						Result++;
						break;
					} else if (i == k) {// k가 자기 자신인 경우 i는 오른쪽으로 이동시켜준다.
						i++;
					} else if (j == k) {// k가 자기 자신인 경우 j는 큰수이므로 왼쪽으로 이동시켜준다.
						j--;
					}

				} else if (A[i] + A[j] < find) {
					i++;
				} else {
					j--;
				}
			}
		}
		System.out.println(Result);
		br.close();

	}

}
