import java.util.Scanner;

public class Code24 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		DFS(2,1); //숫자, 자릿수
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
		sc.close();
	}
	private static void DFS(int number, int jarisu) {
		if (jarisu == N) {  //4 자리수가 되면 소수인지 판별해서 출력해준다.
			if(isPrime(number)) {
				System.out.println(number);
			}
			return;
		}
		for (int i =1; i <10; i++) {
			if(i%2 ==0) {// 짝수라면 더 이상 탐색 할 필요가 없다. 
				continue;
			}
			if(isPrime(number *10 +i)) { //소수라면 재귀함수로 자릿수를 늘림
				DFS(number *10 +i, jarisu + 1);
			}
		}
		
	}
	static boolean isPrime(int num) {// 소수 판별식
		for(int i =2 ; i <=num/2 ; i++) // i*i < num 으로 하면 더 계산을 줄일수 있다고 한다.
			if(num % i ==0)
				return false;
		return true;
	}
	
	

}
