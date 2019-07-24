package datastructures.lists;

import java.util.Arrays;

public class ArrayList<T> {
	private static final int DEFAULT_CAPACITY = 100000;
	private static final float LOAD_FACTOR = 0.75f;

	private T[] arr;
	private int capacity;
	private int size;

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		this.arr = (T[]) new Object[capacity];
		this.capacity = DEFAULT_CAPACITY;
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean needExtend() {
		return this.size > this.capacity * LOAD_FACTOR;
	}

	public void add(T t) {
		this.arr[++this.size - 1] = t;
	}

	public void add(int idx, T t) {
		for (int i = this.size++; i > idx; i--) {
			this.arr[i] = this.arr[i - 1];
		}
		this.arr[idx] = t;
	}

	public int size() {
		return this.size;
	}

	public T get(int idx) {
		return arr[idx];
	}

	public T remove(int idx) {
		T temp = arr[idx];

		for (int i = idx; i < size; i++) {
			this.arr[i] = this.arr[i + 1];
		}
		size--;
		return temp;
	}

	// just for test
	public void print() {
		System.out.println(Arrays.toString(this.arr));
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList();

		list.add(1);
		list.add(2);
		list.add(1,3);
		list.add(4);
		
		list.print();
		
		list.remove(2);
		
		list.print();
		
		System.out.println(list.size());
	}
}
