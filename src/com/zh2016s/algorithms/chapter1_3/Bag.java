package com.zh2016s.algorithms.chapter1_3;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
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

	public void add(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	@Override
	public Iterator<Item> iterator() {
		return new BagIterator();
	}

	private class BagIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {

			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		Bag<String> bag = new Bag<String>();
		bag.add("hello");
		bag.add("world");
		bag.add("!");
		bag.add("hello1");
		bag.add("world1");
		bag.add("!1");
		for (String string : bag) {
			System.out.println(string);
		}
		System.out.println(bag.size());
	}

}
