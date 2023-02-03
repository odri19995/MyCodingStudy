package temp;

import java.util.Scanner;
// 숫자의 합 구하기 백준 11720
public class Code1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 첫번째 줄 입력
		int n = sc.nextInt();
		// 두번째 줄 입력 string
		String nNum = sc.nextLine(); // next를 쓰면 되지만 nextLine()을 쓰고 싶다면 nextInt마지막에 친 enter값을 없애줘야한다.
		//이 코드는 이전 enter를 받아 바로 종료된다. 
		String sNum = sc.nextLine();
		// string 값에서 하나씩 빼서 char배열로 넣어줌
		char[] cNum = sNum.toCharArray();
	
		int sum = 0;
		
		//for 문을 써서 char[i] 값들을 sum 에 더해서 저장한다.
		for(int i = 0; i < n ; i++) {
			sum = sum + cNum[i] -'0'; // '0'의 ''은 char이라는 뜻이다.  '0'의 아스키코드값인 48을 빼줘도 된다.
		}
		System.out.println(sum);
		sc.close();
	}

}
