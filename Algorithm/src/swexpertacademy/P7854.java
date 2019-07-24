package swexpertacademy;

import java.util.Scanner;

public class P7854 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());

		int[] front = new int[] { 1, 2, 5, 10, 20, 25, 50 };
		int[] temp = new int[] { 100, 125, 200, 250, 500 };
		int[] fin = new int[43];
		for (int i = 0; i < 43; i++) {
			if (i < front.length) {
				fin[i] = front[i];
			} else {
				int i7 = i - 7;
				fin[i] = temp[i7 % 5];
				for (int j = 0; j < i7 / 5; j++) {
					fin[i] *= 10;
				}
			}
		}

		for (int t = 1; t <= T; t++) {
			int num = Integer.parseInt(sc.nextLine());

			int i = 0;
			for (i = 0; i < fin.length && num >= fin[i]; i++);

			System.out.printf("#%d %d\n", t, i);
		}

		sc.close();
	}
}