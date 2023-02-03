package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//구간 합 구하기 백준 11659
public class Code3 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer stn = new StringTokenizer(bf.readLine());// bf.readLine(),"." 로 구분자를 설정가능하다. default값은 공백
			int suNo = Integer.parseInt(stn.nextToken());
			int quizNo = Integer.parseInt(stn.nextToken());
			long[] S = new long[suNo +1]; //합 배열 생성하기 배열에선 0번부터기 때문에 첫번째 합배열값부터 쓰기 위함
			stn = new StringTokenizer(bf.readLine());// 새로 한줄 읽어들임 내용: 배열
			
			for (int i = 1; i<suNo; i++) {
				S[i] =S[i-1] + Integer.parseInt(stn.nextToken());
			}
			for (int q =0; q < quizNo; q++) {
			stn = new StringTokenizer(bf.readLine());
			int i = Integer.parseInt(stn.nextToken());
			int j = Integer.parseInt(stn.nextToken());
			System.out.println(S[j]- S[i-1]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
