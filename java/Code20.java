import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Code20 {
	public static int[] A, tmp; //함수에서도 쓸 것이므로 전역변수 선언

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		tmp = new int[N + 1];
		for (int i = 1; i <= N; i++) { // A =[0,1,2,3,4,5] A[1] 때문에 A[0]에는 기본적으로 0값이 들어감
			A[i] = Integer.parseInt(br.readLine());
		}
		merget_sort(1, N); //시작점을 1로 종료점을 N으로
		for (int i = 1; i <= N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	private static void merget_sort(int s, int e) { //s 시작점 e 종료점  m 중간점 //병합정렬 수행하기
		if (e - s < 1)
			return; // void 함수에서 return은 continue 역할 함수를 재시작함
		int m = s + (e - s) / 2; //홀수는 나눌때 소수점이 나오기 때문에 이런식으로 중간을 나눔
		// 재귀함수 형태로 구현
		merget_sort(s, m);// ->A [0,3,4,5,2,1]  3,4,5 부분 정렬
		merget_sort(m + 1, e); //[0,3,4,5,1,2]  1,2 부분 정렬
		for (int i = s; i <= e; i++) {
			tmp[i] = A[i];
		}
		int k = s;
		int index1 = s;
		int index2 = m + 1;
		while (index1 <= m && index2 <= e) { // 두 그룹을 병합하는 로직
			if (tmp[index1] > tmp[index2]) {
// 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고, 선택된 데이터의 index값을 오른쪽으로 한칸 이동하기
				A[k] = tmp[index2];
				k++;
				index2++;
			} else {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while (index1 <= m) { // 한쪽 그룹이 모두 선택된 후 남아있는 값 정리하기
			A[k] = tmp[index1]; //A[3],A[4],A[5] => [3,4,5]
			k++;
			index1++;
		}
		while (index2 <= e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}

	}
}
// 배열에 A[0]번째는 0이며 건드리지 않아도 로직은 잘 돌아갔다.