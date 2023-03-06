package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1448_삼각형_만들기 {
	// N개의 빨대, 빨대 중 3개 선택, 세 변 길이 합의 최댓값 구하기
	// 삼각형의 조건, 가장 큰 변의 길이 < 나머지 두 변의 길이 합
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int cnt = -1;
		
		// 배열에 입력
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 정렬 해주기
		Arrays.sort(arr);
		
		// 맨 뒤에 3개부터 탐색 시작
		int end = N-1; // 맨 마지막 인덱스
//		System.out.println(Arrays.toString(arr));
		while(true) {
//			System.out.println("end :  "+end);
			// 마지막 인덱스가 그 뒤에 두 개 합보다 크면 뒤로 한 칸 이동
			// 종료조건 부여
			if(end-2<0) break;
			
			if(arr[end] >= arr[end-1] + arr[end-2]) {
				end --;
				continue;
			} else {
				cnt = arr[end] + arr[end-1] + arr[end-2];
				break;
			}
		}
		System.out.println(cnt);
		
	}
}
