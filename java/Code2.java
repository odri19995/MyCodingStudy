package temp;

import java.util.Scanner;
// 평균 구하기 백준 1546
public class Code2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 과목의 수
		int num = sc.nextInt();
		int[] arr = new int[num];
		long sum = 0;
		long max = 0;
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < num; i++) {
			sum = sum + arr[i];
			if(arr[i]>max) {
				max= arr[i];
			}

		}
		sc.close();
		System.out.println(sum *100.0 / num / max );  //나누어 떨어지지 않으면 int는 버린다. 순서가 중요!
	}

}
