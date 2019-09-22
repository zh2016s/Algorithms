package com.zh2016s.algorithms.chapter1_3;

public class FixedCapactityStack<T> {
	private T[] a;
	private int N;

	@SuppressWarnings("unchecked")
	public FixedCapactityStack(int cap) {
		a = (T[]) new Object[cap];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(T t) {
		a[N++] = t;
	}

	public T pop() {
		return a[--N];
	}

	public static void main(String[] args) {
		FixedCapactityStack<String> s;
		s = new FixedCapactityStack<String>(100);
		s.push("hello");
		s.push("world");
		s.push("!");
		System.out.println(s.pop() + " " + s.pop() + " " + s.pop());
	}
}
