package sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _18870_좌표압축 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> hm = new HashMap<>(); 
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] copy = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[i] = x;
			copy[i] = x;
		}
		
		Arrays.sort(arr);
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(!hm.containsKey(arr[i])) {
				hm.put(arr[i], cnt++);
			}
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(hm.get(copy[i])+" ");
		}
		
		System.out.println(sb);
	}

}
