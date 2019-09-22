package com.zh2016s.algorithms.chapter1_3;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private Node first;
	private int N;

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseIterator();
	}

	public class ReverseIterator implements Iterator<Item> {
		private int i = N;
		private Node node = first;

		@Override
		public boolean hasNext() {

			return i > 0;
		}

		@Override
		public Item next() {
			Item item = node.item;
			node = node.next;
			i--;
			return item;
		}
	}

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		s.push("Hello");
		s.push("world");
		s.push("!");
		s.push("Hello1");
		s.push("world1");
		s.push("!1");
		for (String string : s) {
			System.out.println(string);
		}
		int size = s.size();
		for (int i = 0; i < size; i++)
			System.out.println(s.pop());
	}
}
