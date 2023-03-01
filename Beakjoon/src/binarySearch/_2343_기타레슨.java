package binarySearch;

import java.util.Scanner;

public class _2343_기타레슨 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 강의 수 N
		int M = sc.nextInt(); // 블루레이의 수 M개
		
		int[] arr = new int[N]; // 강의 배열 저장
		int start = 0; // 하나 강의의 시간이 가장 긴 거
		int end = 0; // 전체 크기
		
		// 배열 저장과 값 체크
		// 배열은 순서대로 저장이 되어있기 때문에 정렬할 필요 없음
		// 시작은 한개의 길이가 가장 큰 것, 끝은 전체 강의의 시간을 다 더한것
		// 예제로치면 9~45까지의 범위
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
			end += arr[i];
			start = Math.max(start, arr[i]);
		}
		
		while(start<=end) { // start와 end값이 같거나 start가 더 작은 동안에 반복
			int mid = (start+end)/2; // Binary Search용 중간값
			int cnt = 1; // 블루레이 수 체크, 1부터 시작
			int sum = 0; // 강의 시간 더할거
			
			for(int i = 0; i<N; i++) {
				if(sum + arr[i] > mid) { // 강의시간에 현재 시간을 더한 값이 중간값보다 크면
					sum = 0; // 더한값 초기화
					cnt++; // 블루레이 수 1올려주기
				}
				sum += arr[i]; // sum값에 현재값 다시 더하기
			}
			// 이렇게 하면 블루레이 필요 개수가 나옴
			if(cnt<=M) { // 체크한 블루레이 수가 제시된 블루레이 수 보다 적거나 같으면
				end = mid-1; // 끝 값을 mid보다 작은 값으로 
			} else {
				start = mid+1; // 블루레이가 더 많으면 시작값을 mid+1값으로
			}
			
		}
		System.out.println(start);
		sc.close();
	}

}
