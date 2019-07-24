package swexpertacademy;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());

		for (int t = 1; t <= T; t++) {
			int P = Integer.parseInt(sc.nextLine());
			int[] arr = new int[P];
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int p = 0; p < P; p++) {
				arr[p] = sc.nextInt();
				if (min > arr[p])
					min = arr[p];
				if (max < arr[p])
					max = arr[p];
			}

			int lcm = multipleLcm(arr);
			if (lcm == max) {
				lcm *= min;
			}

			System.out.printf("#%d %d\n", t, lcm);

			if (sc.hasNextLine()) {
				sc.nextLine();
			}
		}
		sc.close();
	}

	private static int multipleLcm(int[] arr) {
		int lcm = arr[0];

		for (int i = 1; i < arr.length; i++) {
			lcm = lcm(lcm, arr[i]);
		}

		return lcm;
	}

	private static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	private static int lcm(int a, int b) {
		int gcd = gcd(a, b);

		return a * b / gcd;
	}
}