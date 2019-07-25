package datastructures.lists;

public class Stack {
	private static final int DEFAULT_CAPACITY = 10000;

	private int top;
	private int capacity;
	private int[] arr;

	public Stack() {
		this(DEFAULT_CAPACITY);
	}

	public Stack(int capacity) {
		this.capacity = capacity;
		this.top = -1;
		this.arr = new int[capacity];
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void push(int val) {
		if (size() >= this.capacity) {
			throw new RuntimeException("StackOverFlow");
		}

		this.arr[++top] = val;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("StackUnderFlow");
		}
		return this.arr[top--];
	}

	public int seek() {
		if (isEmpty()) {
			throw new RuntimeException("StackUnderFlow");
		}

		return this.arr[top];
	}

	public int size() {
		return this.top + 1;
	}

	public void print() {
		for (int i = 0; i < size(); i++) {
			System.out.print(this.arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Stack stack = new Stack();

		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);

		System.out.println("stack push 3, 4, 5, 6");

		stack.print();

		System.out.printf("size: %d, stack.pop() : %d\n", stack.size(), stack.pop());
		System.out.printf("size: %d, stack.pop() : %d\n", stack.size(), stack.pop());
		System.out.printf("size: %d, stack.pop() : %d\n", stack.size(), stack.pop());

		stack.push(10);
		stack.push(11);
		stack.push(12);

		System.out.println("stack push 10, 11, 12");
		stack.print();

		System.out.printf("size: %d, stack.pop() : %d\n", stack.size(), stack.pop());
		System.out.printf("size: %d, stack.pop() : %d\n", stack.size(), stack.pop());
		System.out.printf("size: %d, stack.pop() : %d\n", stack.size(), stack.pop());
		System.out.printf("size: %d, stack.pop() : %d\n", stack.size(), stack.pop());
		System.out.printf("size: %d, stack.pop() : %d\n", stack.size(), stack.pop());
		System.out.printf("size: %d, stack.pop() : %d\n", stack.size(), stack.pop());
	}
}
