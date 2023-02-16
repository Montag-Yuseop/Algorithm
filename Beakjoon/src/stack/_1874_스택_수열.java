package stack;

import java.util.Scanner;
import java.util.Stack;

public class _1874_스택_수열 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		int[] arr = new int[N];
		boolean check = true;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Stack<Integer> st = new Stack<>();

		int n = 1;
		
		for(int i = 0; i < N; i++) {
			
			if(arr[i] >= n) {
				while(arr[i] >= n) {
					st.push(n++);
					sb.append("+\n");
				}
				st.pop();
				sb.append("-\n");		
			} else {
				int checkNum = st.pop();
				if(checkNum > arr[i]) {
					System.out.println("NO");
					check = false;
					break;
				} else {
					sb.append("-\n");
				}
			}

		}
		if(check) {
			System.out.println(sb);
		}
		sc.close();

	}

}
