import java.util.Scanner;
import java.util.Stack;

public class Code11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		boolean result = true;
		StringBuffer bf = new StringBuffer(); // 저장할 공간
		for (int i = 0; i < A.length; i++) {
			int su = A[i]; // 현재 수열
			if (su >= num) {
				while (su >= num) { // 첫값이 4라면 4까지 num을 증가시켜줘야 후에 pop을 해줄 수 있다.
					stack.push(num++);
					bf.append("+\n");
				}
				stack.pop();// 똑같을때 빼준다.
				bf.append("-\n");
			} else {
				int n = stack.pop();
				// 스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력 할 수 없음
				if (n > su) {
					System.out.println("NO");
					result = false;
					break;
				} else {
					bf.append("-\n");
				}
			}
		}
		sc.close();
		if (result)
			System.out.println(bf.toString());
	}
}
