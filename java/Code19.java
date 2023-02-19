import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code19 {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());
    int N = Integer.parseInt(st.nextToken());// 데이터 개수
    int K = Integer.parseInt(st.nextToken());// K번째 수
    st = new StringTokenizer(in.readLine());
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    quickSort(A, 0, N - 1,  K - 1); // 배열, start , end, K번째 수라해도 배열에서는 k-1과 같다. 2번째 수 는 k[1]
    System.out.println(A[K - 1]);
  }
  public static void quickSort(int[] A, int S, int E, int K) {
      if(S<E){
      int pivot = partition(A, S, E);
      if (pivot == K) { //K번째 수가 pivot이면 더이상 구할 필요 없음
        return;
      }
      else if(K < pivot) {  //K가 pivot보다 작으면 왼쪽만 정렬
        quickSort(A, S, pivot - 1, K); //재귀 함수 호출
      }
      else if(K > pivot){  //K가 pivot보다 크면 왼쪽만 정렬
        quickSort(A, pivot+1, E, K); //start 위치  pivot+1  ~ end
      }
          }
  }

  private static int partition(int[] A, int S, int E){
    if(S+1==E) { //앞의 애가 뒤에 애보다 1밖에 차이 안날때 그냥 교환 해준다. 
      if(A[S]>A[E])swap(A,S,E);
      return E;
    }
    int M = (S + E) / 2;   //중앙값을 피벗으로 설정
    swap(A, S, M); // 중앙값을 1번째 요소로 이동하기 A[0] =2 , A[2] =4
    int pivot = A[S];
    int i = S+1, j = E;
    
    while (i <= j) {
        while (j >= S + 1 && pivot < A[j] ){   //피벗보다 작은 수가 나올때까지 j--
            j--;    
        }
        while (i <= E && pivot > A[i]){  //피벗보다 큰 수가 나올 떄까지 i++
               i ++;  
        }
        if (i <= j) {
            swap (A, i++, j--);  // 찾은 i와 j를 교환하기
        }else {
        	break;
        }
    }
    // i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
    A[S] = A[j];
    A[j] = pivot;
    return j; //피벗의 위치를 반환
}
  
  public static void swap(int[] A, int i, int j) { // swap 기능을 swap함수로 만들어준다.
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}


//중앙값을 피벗으로 설정했지만 pivot은 실질적으로 데이터에서 어떤 값을 설정해도 상관없다고 한다. 
//피벗 값을 중심으로 피벗보다 작은 데이터와 피벗보다 큰 데이터로 나누어주는 로직만 잘 구현이 되면 된다.