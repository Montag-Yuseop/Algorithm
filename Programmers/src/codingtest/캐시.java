package codingtest;

import java.util.ArrayList;

public class 캐시 {
	public static void main(String[] args) {
		
		int cacheSize = 3;
		int cnt = 0;
		
		String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
		
		ArrayList<String> list = new ArrayList<>();
		
		// 도시 수 만큼 반복
		for(int i = 0; i < cities.length; i++) {
			// 캐시 사이즈가 list의 최대 크기
			
			
			// list안에 대소문자 구별 없이 같은 도시가 있으면
			boolean check = false;
			for(int j = 0; j < list.size(); j++) {
				if(list.get(j).equalsIgnoreCase(cities[i])) {
					// j 지우고
					list.remove(j);
					// 맨 뒤에 추가
					list.add(cities[i]);
					// 시간은 1초만 소요
					cnt += 1;
					check = true;
					break;
				}
			}
			
			if(!check) {
				list.add(cities[i]);
				cnt+=5;
			}
			
			if(list.size() > cacheSize ) {
				while(list.size() != cacheSize) {
					list.remove(0);
				}
			}
			
		}
		System.out.println(cnt);
		
	}

}
