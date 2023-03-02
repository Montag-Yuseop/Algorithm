package day0302;

import java.util.Scanner;

public class _1966_숫자를_정렬하자 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc<T+1; tc++) {
			int N = sc.nextInt();
			
			int[] A = new int[N];
			
			for(int i = 0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			
			// 주어진 배열 이용해서
			// 힙 만들기
			// 루트 인덱스 0
			
			// 자식이 있는 노드는 0부터 (n/2 -1)번호까지 자식이 있는 노드
			// 자식이 있는 노드를 점검하여 최대 힙을 만들어야 한다
			
			for(int i =N/2-1; i>=0; i--) {
				heapify(A, N, i);
			}
			
			for(int i = N-1; i>0; i--) {
				int temp = A[0];
				A[0] = A[i];
				A[i] = temp;
				
				heapify(A, i, 0);
			}
			
			System.out.print("#"+tc);
			for(int i = 0; i<N; i++) {
				System.out.print(" "+A[i]);
			}
			System.out.println();
		}
		
	}

	// A는 주어진 배열
	// N은 어디까지가 힙? 힙의 크기(원소의 개수)
	// 제일 처음에는 N
	// 다음에는 N-1, N-2 ...
	// i는 그 힙 안에서 몇번째 원소에 대해 힙만들기를 수행할 것인지?
	// 몇번쨰 원소를 힙의 성질을 만족하도록 할 것인지
	
	
	// i번째 원소가 최대힙의 성질을 만족하도록 만들기
	private static void heapify(int[] A, int N, int i) {
		// 비교해야 하는 것은
		// 부모
		// 왼쪽 자식, 오른쪽 비교
		
		
		// 이 셋 중에서 가장 큰 것을 찾아야 한다
		// 부모가 가장 크다고 가정
		
		int largest = i;
		int l = 2 * i + 1; // 왼쪽자식, 인덱스가 0부터 시작하기 때문
		int r = 2 * i + 2;

		// 힙의 범위 안에 있어야 한다
		// 왼쪽 자식이 힙 범위 안에 있고, 부모보다 크다면
		if(l<N && A[l]>A[largest]) {
			largest = l;
		}
		
		// 오른쪽 자식이 힙의 범위 안에 있고
		// 오른쪽 자식이 더 크다면
		if(r < N && A[r] > A[largest] ) {
			largest = r;
		}
		
		// 경우는 두 가지
		// 1. 가장 큰 값이 부모인 경우(largest == i) 아무것도 안하면 됨
		// 2. 가장 큰 값이 자식인 경우 (largest != i) >
		//	부모와 자식을 교환한 후에 자식에 대해 또 힙 만들기 수행
		
		if(largest != i) {
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			
			heapify(A, N, largest);
			
		}
		
	}

}
