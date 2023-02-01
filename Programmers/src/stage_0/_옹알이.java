package stage_0;

import java.io.IOException;

public class _옹알이 {

	public static void main(String[] args) throws IOException {
		
		String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
		
		String[] arr = {"aya", "ye", "woo", "ma"};
		
		int answer = 0;
		
		outer : for(int i=0; i<babbling.length; i++) {
			for(int j=0; j< arr.length; j++) {
				
				if(babbling[i].contains(arr[j])) {
					answer++;
					break outer;
				}
				
			}
			
		}
		System.out.println(answer);
				

	}

}
