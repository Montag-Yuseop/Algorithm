package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class _10989_수_정렬하기3 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[10001];
		
		for(int i=0; i<N; i++) {
			arr[Integer.parseInt(bf.readLine())]++;
		}
		
		bf.close();
		
		for(int i=0; i<arr.length; i++) {
			while(arr[i]>0) {
				sb.append(i).append("\n");
				arr[i]--;
			}
		}
		
		System.out.println(sb);
	}

}
