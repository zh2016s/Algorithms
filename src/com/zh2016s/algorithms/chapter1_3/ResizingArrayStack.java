package com.zh2016s.algorithms.chapter1_3;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {

	@SuppressWarnings("unchecked")
	private Item[] a = (Item[]) new Object[1];
	private int N = 0;

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void push(Item item) {
		if (N == a.length)
			resize(2 * a.length);
		a[N++] = item;
	}

	public Item pop() {
		Item item = a[--N];
		a[N] = null;
		if (N > 0 && N == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return a[--i];
		}
	}

	public static void main(String[] args) {
		ResizingArrayStack<String> s = new ResizingArrayStack<String>();
		s.push("Hello");
		s.push("world");
		s.push("!");
		s.push("Hello");
		s.push("world");
		s.push("!");
		for (String string : s) {
			System.out.println(string);
		}
		System.out.println(s.pop() + " " + s.pop() + " " + s.pop() + " " + s.pop() + " " + s.pop() + " " + s.pop());
	}
}
