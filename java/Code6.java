import java.util.Scanner;

public class Code6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1; // 숫자 1개만 뽑는 경우의 수 여기서는 15만 뽑는 경우의 수
		int start_index = 1;
		int end_index = 1;
		int sum = 1; // start와 end가 1이라 sum은 1이다.
		while (end_index != N) { // end 가 15는 이미 계산해놨으므로 배제한다.
			if (sum == N) {
				count++;
				end_index++;
				sum = sum + end_index; // 15 + end index
			} else if (sum > N) {
				sum = sum - start_index;
				start_index = start_index + 1;
			} else {
				end_index++;
				sum = sum + end_index;
			}

		}
		System.out.println(count);
		sc.close();
	}

}
