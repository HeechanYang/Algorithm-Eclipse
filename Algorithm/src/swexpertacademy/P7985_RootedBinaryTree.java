package swexpertacademy;

import java.util.Scanner;

public class P7985_RootedBinaryTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());

		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(sc.nextLine());

			Queue q = new Queue(2000);
			Queue q2 = new Queue(2000);
			int N = 1;
			for (int k = 0; k < K; k++)
				N *= 2;
			N--;

			int[] arr = new int[N];
			for (int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}

			q.push(0, N - 1);

			while (!q.isEmpty()) {
				int[] temp = q.pop();
				int left = temp[0];
				int right = temp[1];
				int mid = (left + right) / 2;
				q2.push(arr[mid], 0);

				if (left <= right) {
					q.push(left, mid - 1);
					q.push(mid + 1, right);
				}
			}

			System.out.printf("#%d ", t);
			for (int k = 0; k < K; k++) {
				int temp = 1;
				for (int tmp = 0; tmp < k; tmp++)
					temp *= 2;

				for (int tmp = 0; tmp < temp; tmp++) {
					System.out.printf("%d ", q2.pop()[0]);
				}
				System.out.println();
			}

			sc.nextLine();
		}
	}

	static class Queue {
		private int front;
		private int rear;
		private int[][] datas;

		public Queue(int size) {
			this.datas = new int[size][2];
			this.front = -1;
			this.rear = -1;
		}

		public void push(int left, int right) {
			if (isFull())
				throw new RuntimeException("push in full queue");
			datas[++rear][0] = left;
			datas[rear][1] = right;
		}

		public int[] pop() {
			if (isEmpty())
				throw new RuntimeException("pop in empty queue");
			return datas[++front];
		}

		public boolean isEmpty() {
			return this.front == this.rear;
		}

		public boolean isFull() {
			return this.rear == datas.length - 1;
		}
	}
}
