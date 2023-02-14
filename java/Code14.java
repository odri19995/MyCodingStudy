import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Code14 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> MyQue = new PriorityQueue<>((o1, o2) -> { //비교할 객체 2개 선언

			// 절댓값 같은 경우 음수 우선
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if (first_abs == second_abs) {
				return o1 > o2 ? 1 : -1; // 앞조건 참이면 1 아니면 -1 리턴
			}
			return first_abs - second_abs  ; // 첫째 데이터가 크면 양수 첫째 데이터가 작으면 음수 //절댓값 작은 데이터 우선 (0과의 거리가 가장 가까운데이터)
			//second_abs - first_abs 절댓값이 큰 데이터일 수록 앞으로 온다.

		});

		for (int i = 0; i < N; i++) {
			int request = Integer.parseInt(bf.readLine());
			if (request == 0) {
				if (MyQue.isEmpty())
					System.out.println("0"); // 비어있으면 0
				else
					System.out.println(MyQue.poll()); // 정렬이 잘되어 있기 때문에 그냥 뽑으면 된다.
			} else {
				MyQue.add(request);
			}
		}

	}

}


// PriorityQueue<Integer> Myqueue = new PriorityQueue<>( (n1, n2) -> {	} ) ;
//보다 정렬의 조건을 세분화하고 문제의 조건에 맞게 하기 위해 오버라이드 함
// 문법 람다식 사용 priorityQue -> comparator  재정의

