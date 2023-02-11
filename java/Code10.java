import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Code10 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 출력을 그때 그때 하는 것보다 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter를 사용
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));// 출력값을 한줄에 나열하고 싶을 때 쓰면 된다.
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    Deque<Node> mydeque = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      int now = Integer.parseInt(st.nextToken());
      // 새로운 값이 들어 올 때마다 정렬하지 않고 현재 수보다 큰 값을 덱에서 제거함으로써 시간복잡도를 줄일 수 있음
      while (!mydeque.isEmpty() && mydeque.getLast().value > now) { //mydeque가 비어있지 않고 mydeque의 맨 오른쪽 값이 현재 비교값보다 클경우
        mydeque.removeLast();
      }
      mydeque.addLast(new Node(now, i));
      // 범위에서 벗어난 값은 덱에서 제거
      if (mydeque.getFirst().index <= i - L) {  //범위를 벗어난 값 제거
        mydeque.removeFirst();
      }
      bw.write(mydeque.getFirst().value + " ");
    }
    bw.flush(); //버퍼에 잔류하는 모든 문자열을 출력한다. #바이트가 8192를 넘어가도 출력하게 해준다. 
    bw.close(); //사용한 시스템 자원을 모두 반납하고 출력 스트링을 닫는다.
  }

  static class Node {
    public int value;
    public int index;

    Node(int value, int index) { // Node의 생성자 메서드
      this.value = value;
      this.index = index;
    }
  }
}