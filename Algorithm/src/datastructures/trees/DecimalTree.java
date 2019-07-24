package datastructures.trees;

import java.util.Scanner;

public class DecimalTree {
	private static final int CHILDREN_COUNT = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for (int t = 1; t <= T; t++) {
			DecimalTree tree = new DecimalTree();

			int N = Integer.parseInt(sc.nextLine());
			
			String[] strs = new String[N];
			for (int n = 0; n < N; n++) {
				strs[n] = sc.nextLine();
			}

			boolean isSuccess = true;
			for (String str : strs) {
				if (!tree.put(str)) {
					isSuccess = false;
					break;
				}
			}
			System.out.println(isSuccess ? "YES" : "NO");
		}

		sc.close();
	}

	private Node root;

	public DecimalTree() {
		this.root = new Node();
	}

	public boolean put(String key) {
		Node n = this.root;

		char[] cArr = key.toCharArray();
		for (int k = 0; k < cArr.length; k++) {

			int i = cArr[k] - '0';
			Node child = n.children[i];
			if (child == null) {
				n.children[i] = new Node();
			} else {
				if (child.isEnd || k == cArr.length - 1) {
					return false;
				}
			}

			n = n.children[i];
		}
		n.isEnd = true;

		return true;
	}

	static class Node {
		private Node[] children;
		private boolean isEnd;

		public Node() {
			this.children = new Node[CHILDREN_COUNT];
			this.isEnd = false;
		}

		public Node[] getChildren() {
			return children;
		}
	}
}
