import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Code13 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		Scanner sc = new Scanner(System.in); // scanner 는 키를 누르는 즉시 바로 전달됨
		Queue<Integer> myQue = new LinkedList<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//bufferedReader는 버퍼에 잠시 저장했다가. 버퍼가 가득차거나 개행문자가 나타나면  버퍼의 내용을 한번에 전달함
		int N = Integer.parseInt(bf.readLine());
//		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			myQue.add(i);
		}
		while (myQue.size()>1) {
			myQue.poll();
			myQue.add(myQue.poll());
		}
		System.out.println(myQue.poll());// 앞부분에 있는 데이터를 삭제하고 확인하는 연산이다. 
		sc.close();
	}

}
/* 오늘은 비교적 쉬웠다. 
 * 오늘은 Exception 에 간단히 정리하려고 한다.
 * 예외의 종류에는 두가지가 있다. 컴파일시 발생하는 컴파일 에러 프로그램이 구동되는 중에 발생하는 런타임 에러가 있다.
 * 컴파일 오류의 경우에는 대체로 문법상의 오류때문에 많이 발생합니다.
 * 런타임 오류의 경우에는 대체로 설계가 잘못되어 발생하는 경우가 많습니다. 
 * 자바는 이러한 Exception을 처리하기 위해서 java.lang.Exception이라는 최상위 클래스를 제공합니다.
 * 자바에서 기본적인 예외처리는 아래와 같이 try catch 문법을 통해 진행합니다.
 * try 블록에 실제 실행되어야 하는 코드가 들어가며 Exception이 발생할 가능성이 있는 코드가 들어갑니다.
 * catch 블록에는 Exception이 발생하면 실행되는 코드가 들어갑니다. 즉 예외처리를 하는 코드입니다.
 * finally 블럭에는 어떠한 예외가 발생하더라도 반드시 실행되어야 하는 코드가 들어가는 곳입니다.
 *  throw 키워드를 사용하면 개발자의 판단에 따라 강제로 예외를 발생시킬 수 있습니다.
 *  throws의 경우 메서드 내에서 예외처리를 하지 않고 해당 메서드를 사용한 곳에서 예외 처리를 하도록 예외를 위로 던지는 것입니다. 예외를 전가하는 것 입니다.
 *  throws를 사용하는 이유는 예외가 발생할 수 있는 코드가 있다는 것을 인지시키고 예외처리를 강요하며, 여러 가지 발생 가능한 예외들을 호출한 메서드에서 한 번에 처리할 수 있게 하여 관리를 용이하게 해 줄 수 있습니다.
 * 
 * NumberFormatException 부적절한 문자열을 수치로 변환하고자 할때 발생하는 에러 */
 