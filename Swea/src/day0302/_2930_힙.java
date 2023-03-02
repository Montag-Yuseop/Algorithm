package day0302;

import java.util.Scanner;

public class _2930_힙 {
	// 배열에 교환 연산 -> swap
	static int[] arr; // 완전 이진트리(힙)을 나타낼 배열
	static int lastIdx; // 배열에서 마지막 원소 인덱스

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			System.out.print("#" + tc);

			// 각 테스트케이스에서 연산의 수 N이 주어짐
			int N = sc.nextInt();
			arr = new int[N + 1]; // N번까지 삽입되어야 한다
			lastIdx = 0; // 초기화, ++lastIdx로 사용할 것

			// 명령어 수 N만큼 반복
			for (int i = 0; i < N; i++) {
				// 명령어 숫자입력 필요
				int c = sc.nextInt();

				if (c == 1) { // c가 1이면 삽입 명령 > 힙에 추가
					// 배열의 가장 마지막 인덱스에 추가해서 루트로 거슬러 올라감
					int num = sc.nextInt();
					arr[++lastIdx] = num;
					int cur = lastIdx; // 현재 노드를 마지막 노드에서 출발 > 부모와 비교
					// 거슬러 올라감

					// cur은 자식의 입장, 항상 부모랑 비교, 루트노드 전까지 가야함

					// while문: 언제 반복하고 언제 종료?
					// 현재 노드 - arr[cur], 부모노드 arr[cur/2]
					// 종료는 최대힙 만족 > 부모>= 자식(cur)

					while (cur > 1 && arr[cur] > arr[cur / 2]) {
						swap(cur, cur / 2); // 교환하고
						cur = cur / 2; // 현재 인덱스를 부모 인덱스로 변경
					}

				} else if (c == 2) { // c가 2이면 삭제명령 > 루트 출력, 힙 삭제
					// 루트 삭제, 가장 마지막 원소를 루트로 옮기고, 루트에서 리프로 내려감

					// 현재 루트 노드의 값을 먼저 출력
					// 루트 노드 arr[i]
					if (lastIdx == 0) {
						System.out.print(" -1");
					} else {
						System.out.print(" " + arr[1]);

						// 마지막 원소를 루트 노드로 옮기기
						// 마지막 원소 arr[lastIdx]
						arr[1] = arr[lastIdx];
						// 마지막 노드 삭제
						arr[lastIdx--] = 0;

						// 루트 노드에서 시작
						// cur는 부모
						int cur = 1; // 현재 위치를 루트 노드로

						// 언제 반복?
						// - cur < 자식
						// - 자식 두개 비교도 해줘야함

						// 언제 종료?
						// - 리프노드에 가면 중단
						// - cur>= 자식

						while (true) {
							int child = cur * 2; // 왼쪽 자식으로 놓고 생각
							// 오른쪽 자식도 있으면 비교하도록 함
							// 오른쪽 자식이 존재하고 오른쪽 자식이 더 크다면
							if (child + 1 <= lastIdx && arr[child] < arr[child + 1]) {
								child++; // 오른쪽 자식을 선택
							}

							// 여기까지 오면 둘 중 큰 자식을 찾음
							// 둘 중 큰 자식의 idx가 child에 들어있음

							// 부모가 자식보다 커서 힙의 순서가 맞으면 종료
							// 더이상 자식이 없는 리프노드에 가면 종료

							if (child > lastIdx || arr[child] <= arr[cur])
								break;

							swap(cur, child);
							cur = child;

						}
					}

				}

			}
			System.out.println();
		}

	}

	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
