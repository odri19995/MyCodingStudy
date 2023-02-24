import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code22_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[10001];
		
		for( int i =0; i < N ; i ++) {
			int number = Integer.parseInt(br.readLine());
			count[number]++;
		}
		br.close();
		for( int i =0; i < 10000; i++) {
			if(count[i] !=0) {
				for(int j =0; j <count[i]; j++) {
					System.out.println(i);
				}
			}
			
		}
	}
}
