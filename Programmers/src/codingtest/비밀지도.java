package codingtest;

public class 비밀지도 {
	
	public static void main(String[] args) {
		
		int n = 16;
		long x1 = 100000;
		long y1 = 30;
		
		String x = Long.toBinaryString(x1);
		String y = Long.toBinaryString(y1);
		
		String a = String.format("%0"+n+"d", Long.parseLong(x));
		String b = String.format("%0"+n+"d", Long.parseLong(y));
		
		for(int i = 0; i < n; i++) {
			int num1 = a.charAt(i) - '0';
			int num2 = b.charAt(i) - '0';
			
			if((num1|num2) == 1) {
				System.out.print("#");
			} else {
				System.out.print(" ");
			}
			
		}
		System.out.println();
		System.out.println(a);
		System.out.println(b);
		
		String s = "";
		
		s += "1";
		s+= " ";
	}

}

