import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code9 {
	static int checkArr[]; // 이렇게 선언하면 외부함수에서도 잘 쓸 수 있다.
	static int myArr[];
	static int checkSecret;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Result = 0;
		char A[] = new char[S];
		checkArr = new int[4];
		myArr = new int[4];
		checkSecret = 0; // 조건이 맞을 수록 CheckSecret이 올라간다. 조건이 4개다 만족하면 checkSecret은 4가 된다.밖에서 선언 해줘서 또 해주면 안된다.
		A = bf.readLine().toCharArray(); // DNA 문자열을 char형식 배열로 저장
		st = new StringTokenizer(bf.readLine()); // ACGT 받기
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if (checkArr[i] == 0)
				checkSecret++;// 이미 만족했을 경우
		}
		for (int i = 0; i < P; i++) {
			Add(A[i]); // 현재 상태 배열에 하나씩 넣어주려고 한다.
		}
		if (checkSecret == 4) //조건 4개가 모두 만족시 count +1
			Result++;
		// 슬라이딩 윈도우 처리 부분
		for (int i =P; i<S; i++) {
			int j = i-P;
			Add(A[i]); //슬라이드 끝부분에 하나 추가
			Remove(A[j]);//슬라이드 앞부분에 하나 제거
			if (checkSecret ==4)
				Result++;
		}
		System.out.println(Result);
		bf.close();
		

	}

             // function part//
	private static void Add(char c) {
		switch (c) {
		case 'A':
			myArr[0]++;
			if (myArr[0] == checkArr[0]) // 1문자당 한번이기 때문에 ==를 써야 한다.
				checkSecret++;
			break;
		case 'C':
			myArr[1]++;
			if (myArr[1] == checkArr[1])
				checkSecret++;
			break;
		case 'G':
			myArr[2]++;
			if (myArr[2] == checkArr[2])
				checkSecret++;
			break;
		case 'T':
			myArr[3]++;
			if (myArr[3] == checkArr[3])
				checkSecret++;
			break;
		}

	}
	
	private static void Remove(char c) {
		switch(c) {
		case 'A':
			if (myArr[0] == checkArr[0]) //이번에 빠짐으로서 충족이 안되므로 checkSecret을 하나 빼준다.
				checkSecret--;
			myArr[0]--;
			break;
		case 'C':
			if (myArr[1] == checkArr[1])
				checkSecret--;
			myArr[1]--;
			break;
		case 'G':
			if (myArr[2] == checkArr[2])
				checkSecret--;
			myArr[2]--;
			break;
		case 'T':
			if (myArr[3] == checkArr[3])
				checkSecret--;
			myArr[3]--;
			break;
		}
		
	}

}
