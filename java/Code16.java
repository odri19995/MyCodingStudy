import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Code16 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		mData[] A = new mData[N];
		for(int  i = 0; i<N;i++) {
			A[i] = new mData(Integer.parseInt(bf.readLine()),i);
		}
		Arrays.sort(A);
		int Max = 0;
		for(int i =0 ; i <N; i++) { // 정렬전 index = A[].index 정렬 후 index = i
			if (Max < A[i].index -1) {// 정렬전 index -정렬후 index 계산의 최댓값 저장하기
				Max = A[i].index-i;
			}
		}
		System.out.println(Max +1);	
	}
}

class mData implements Comparable<mData>{ //부모는 선언만 하며 자식이 정의를 오버라이딩 해서 사용해야 한다.
	int value;
	int index;
	
	
	public mData(int value, int index) {
		super(); // 부모 클래스의 생성자 호출
		this.value = value;
		this.index = index;
	}
	//컴파일러가 항상 super()를 자동 추가해주는 것은 아니다.
	//부모클래스에 기본 생성자가 아닌 매개변수를 가지는 생성자가 있다면(=부모클래스에서 생성자가 오버로딩되면) 자동으로 추가되지 않음 (=묵시적 제공을 하지 않음)


	@Override
	public int compareTo(mData o) { // value 기준 오름차순으로 정렬하기
		return this.value - o.value;
	}
	
	
}
