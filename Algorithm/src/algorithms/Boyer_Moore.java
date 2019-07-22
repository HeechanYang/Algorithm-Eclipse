package algorithms;

public class Boyer_Moore {
	private static final int ASCII_SIZE = 255;

	public static int boyerMoore(String str_, String pattern_) {
		char[] str = str_.toCharArray();
		char[] pattern = pattern_.toCharArray();

		int strLen = str_.length();
		int patternLen = pattern_.length();

		// skip 배열 초기화 시작
		int[] skip = new int[ASCII_SIZE];

		for (int i = 0; i < ASCII_SIZE; i++) {
			skip[i] = patternLen;
		}

		for (int i = 0; i < patternLen; i++) {
			skip[pattern[i]] = patternLen - i - 1;
		}
		// skip 배열 초기화 끝

		// 검색 시작
		for (int i = patternLen - 1; i < strLen;) {
			int t = i;
			int j = patternLen - 1;
			while (j >= 0 && str[t--] == pattern[j--]);
			t++;
			if (j == -1)
				return t;
			
			int k = skip[str[t]];
			System.out.println(i + " " + j + " " + t + " " + k);
			i += k;
		}

		return -1;
	}

	public static void main(String[] args) {
		String s = "bbbbabcdabcd";
		String pattern = "cdab";
		System.out.println(boyerMoore(s, pattern));
	}
}
