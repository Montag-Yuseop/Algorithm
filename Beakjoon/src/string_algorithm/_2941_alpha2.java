package string_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2941_alpha2 {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String s = bf.readLine();
		int cnt = 0;

		for (int i = 0; i < s.length(); i++) {

			char a = s.charAt(i);

			if (a == 'c') {
				if (i < s.length() - 1) {
					if (s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {
						cnt++;
						i++;

					} else {
						cnt++;
					}
				} else {
					cnt++;
				}

			} else if (a == 'd') {
				if (i < s.length() - 1) {
					if (s.charAt(i + 1) == 'z') {
						if (s.charAt(i + 2) == '=') {
							cnt++;
							i += 2;
						} else {
							cnt++;
							i++;
						}

					} else if (s.charAt(i + 1) == '-') {
						cnt++;
						i++;
					} else {
						cnt++;
					}
				} else {
					cnt++;
					}
				
			} else if (a == 'l' || a == 'n') {
				if (i < s.length() - 1) {
					if (s.charAt(i + 1) == 'j') {
						cnt++;
						i++;
					} else {
						cnt++;
					}
				} else {
					cnt++;
				}

			} else if (a == 's') {
				if (i < s.length() - 1) {
					if (s.charAt(i + 1) == '=') {
						cnt++;
						i++;
					} else {
						cnt++;
					}
				} else {
					cnt++;
				}
				
			} else if (a == 'z') {
				if (i < s.length() - 1) {
					if (s.charAt(i + 1) == '=') {
						cnt++;
						i++;
					} else {
						cnt++;
					}
				}
			} else {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}

//			틀림... 오류
//			case 'c':
//				if (i + 1 < s.length()) {
//					if (s.charAt(i + 1) == '=') {
//						cnt--;
//					} else if (s.charAt(i + 1) == '-') {
//						cnt--;
//					}
//
//				} else {
//					continue;
//				}
//				break;
//
//			case 'd':
//				if (i + 1 < s.length()) {
//					if (s.charAt(i + 1) == 'z') {
//						cnt--;
//						if (s.charAt(i + 2) == '=') {
//							cnt--;
//						}
//					} else if (s.charAt(i + 1) == '-') {
//						cnt--;
//					}
//				} else {
//
//					continue;
//
//				}
//				break;
//
//			case 'l':
//				if (i + 1 < s.length()) {
//					if (s.charAt(i + 1) == 'j') {
//						cnt--;
//					} else {
//						continue;
//					}
//				}
//				break;
//
//			case 'n':
//				if (i + 1 < s.length()) {
//					if (s.charAt(i + 1) == 'j') {
//						cnt--;
//					} else {
//
//						continue;
//					}
//				}
//				break;
//
//			case 's':
//				if (i + 1 < s.length()) {
//					if (s.charAt(i + 1) == '=') {
//						cnt--;
//
//					} else {
//						continue;
//					}
//				}
//				break;
//
//			case 'z':
//				if (i + 1 < s.length() && i - 1 > 0) {
//					if (s.charAt(i + 1) == '=' && s.charAt(i - 1) != 'd') {
//						cnt--;
//					
//				} else {
//					continue;
//					}
//				}
//				break;
//
//			}
//		}
