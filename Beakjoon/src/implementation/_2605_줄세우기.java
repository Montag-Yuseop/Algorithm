package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class _2605_줄세우기 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		br.close();
		
		for(int i = 0; i < N; i++) {
			
			
			int a = Integer.parseInt(st.nextToken());
			list.add(i-a, i+1);
			
	
		}
		
		for(int data : list) {
			System.out.print(data + " ");
		}
		
	}

}
