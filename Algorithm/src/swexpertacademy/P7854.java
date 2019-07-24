package swexpertacademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P7854 {
	public static void main(String[] args) throws IOException{
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

			int T = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();

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
				int num = Integer.parseInt(br.readLine());

				int i = 0;
				for (i = 0; i < fin.length && num >= fin[i]; i++)
					;

				sb.append(String.format("#%d %d\n", t, i));
			}
			
			bw.write(sb.toString());
			bw.flush();
		}
	}
}