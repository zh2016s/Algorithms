package com.zh2016s.algorithms.chapter1_3;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
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

	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty())
			first = last;
		else
			oldlast.next = last;
		N++;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if (isEmpty())
			last = null;
		N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<Item> {
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
		Queue<String> queue = new Queue<String>();
		queue.enqueue("Hello");
		queue.enqueue("world");
		queue.enqueue("!");
		queue.enqueue("Hello1");
		queue.enqueue("world1");
		queue.enqueue("!1");
		for (String string : queue) {
			System.out.println(string);
		}
		int a = queue.size();
		for (int i = 0; i < a; i++) {
			System.out.println(queue.dequeue());
		}
	}

}
