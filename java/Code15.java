import java.util.Arrays;
import java.util.Scanner;

public class Code15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] box = new int[N];
		for (int i = 0; i < N; i++) {
			box[i] = sc.nextInt();
		}
		for (int i =0; i <N-1;i++) {// 루프는 마지막전까지
			for(int j =0; j <N-1-i; j++) {
				if(box[j] > box[j+1]) {
					int temp =box[j];  //서로 값을 바꾸는 메커니즘 a b값 바꾸기
					box[j] = box[j+1];
					box[j+1] =temp;
					
				}
			}
		}
		for(int i =0;i<N; i++) {
			System.out.println(box[i]);
		}
		sc.close();

	}
}

//public class Code15 { sort로 정렬하기 
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] box = new int[N];
//		for (int i = 0; i < N; i++) {
//			box[i] = sc.nextInt();
//		}
//		Arrays.sort(box);
//		for (int i : box) {
//			System.out.println(i);
//		}
//	}
//
//}

//System.out.println(Arrays.toString(box)); box : [I@4cdbe50f ->Arrays.toString(box) : [1, 2, 3, 4, 5] 
/*
 * 향상된 for 문
 * 
 * for(자료형 변수명 : 배열명){ 문장 }
 * 
 */
//sort를 쓰려면 Arrays를 import 해야 한다. !!!

/*
보편적으로 배열을 정렬할 땐 Arrays.sort(), 컬렉션(List,Set..)을 정렬할 땐 Collections.sort()를 사용한다.

찾아보니 같은 sort 메서드지만 내부에서는 다른 정렬방식을 사용하여 정렬한다고 한다.
 이에 따라 시간복잡도도 달라 각 자료구조를 사용할 때 효율성 테스트의 성공/실패 결과가 달라질 수 있다. 이에 대한 내용을 간단히 정리해보자.
 
 Arrays.sort() ; DualPivotQuicksort :평균 ; O(nlog(n)) / 최악 : O(n^2)
 Collections.sort()	; TimeSort (삽입정렬과 합병정렬을 결합한 정렬) ; 평균, 최악 : O(nlog(n))
 최악이 O(nlog(n))의 시간복잡도를 갖고 있는 Collections의 sort()이 더 빠르며 평균 정렬 알고리즘으로 채택하여 사용하고 있다고 한다.
*/