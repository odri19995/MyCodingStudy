import java.util.Scanner;
import java.util.stream.Stream;

public class Code17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();		
		int[] A = new int[str.length()];
		for (int i = 0; i < str.length(); i++)      //방법 1. substring 사용
			A[i] = Integer.parseInt(str.substring(i, i + 1));
		
//        for (int i = 0; i < str.length(); i++)  //방법 2. string을 char로 변환해서 빼오고 연산을 해서 int값으로 변환해준다.
//            A[i] = str.charAt(i) - '0';
		
//		int[] A = Stream.of(str.split(""))
//		.mapToInt(Integer::parseInt).toArray(); //방법 3 
		for (int i = 0; i < str.length(); i++) {
			int Max = i; // 내림 차순이므로 맨앞에 오는 값은 최댓값이다. 
			for (int j = i + 1; j < str.length(); j++) {
				if (A[j] > A[Max])
					Max = j;
			}
			if (A[i] < A[Max]) {
				int temp = A[i];
				A[i] = A[Max];
				A[Max] = temp;
			}
		}
//		for (int i =0; i< str.length(); i++) {
//			System.out.print(A[i]);
//		}
		
		for (int  i : A) {
			System.out.print(i);
		}
		sc.close();
	}

}
// 자바 ::더블콜론 이란?

//메소드 레퍼런스라고도 불린다. 자바8 버전에서 소개되었다. 람다식과 똑같은 기능을 한다.

//람다식과 차이점이 있다면 인스턴스를 활용하여 메소드를 전달하는데에 있다.

//list.forEach(item -> System.out.println(item));
//list.forEach(System.out::println);


//2. 더블콜론의 사용처
//사용하는 람다식이 기존에 있는 인스턴스의 메소드와 동일하면 메소드 레퍼런스로 대체 가능하다
//스태틱 메소드, 인스턴스의 메소드의 메소드 레퍼런스로 사용가능하다