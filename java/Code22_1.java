import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Code22_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[10001];
		
		for( int i =0; i < N ; i ++) {
			int number = Integer.parseInt(br.readLine());
			count[number]++;
		}
		br.close();
		for( int i =0; i < 10001; i++) {
			if(count[i] !=0) {
				for(int j =0; j <count[i]; j++) {
					bw.write(i + "\n");
				}
			}
			
		}
		bw.flush();
		bw.close();
	}
}