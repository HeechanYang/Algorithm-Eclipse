package swexpertacademy;

import java.util.Scanner;

public class P4008_MakeNumber {
	private static int N;
	private static int[] ops;
	private static int[] nums;
	private static int min, max;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int T = Integer.parseInt(sc.nextLine());

			for (int t = 1; t <= T; t++) {
				N = Integer.parseInt(sc.nextLine());

				ops = new int[4];
				nums = new int[N];

				min = Integer.MAX_VALUE;
				max = Integer.MIN_VALUE;

				for (int i = 0; i < 4; i++) {
					ops[i] = sc.nextInt();
				}

				if (sc.hasNext()) {
					sc.nextLine();
				}

				for (int i = 0; i < N; i++) {
					nums[i] = sc.nextInt();
				}

				if (sc.hasNext()) {
					sc.nextLine();
				}

				solution(nums[0], 1);
				System.out.printf("#%d %d\n", t, max - min);
			}
		}
	}

	private static void solution(int n, int position) {
		if (position == N) {
			if(max < n) max = n;
			if(min > n) min = n;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (ops[i] > 0) {
				ops[i]--;
				int tempN = n;
				switch (i) {
				case 0:
					tempN += nums[position];
					break;
				case 1:
					tempN -= nums[position];
					break;
				case 2:
					tempN *= nums[position];
					break;
				case 3:
					tempN /= nums[position];
					break;
				}
				solution(tempN, position + 1);
				ops[i]++;
			}
		}
	}
}
