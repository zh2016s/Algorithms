package com.zh2016s.algorithms.chapter1_3;

public class FixedCapacityStackOfStrings {
	private String[] a;
	private int N;
	public FixedCapacityStackOfStrings(int cap) {
		a = new String[cap];
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	public void push(String item) {
		a[N++]=item;
	}
	public String pop() {
		return a[--N];
	}
	
	public static void main(String[] args) {
		FixedCapacityStackOfStrings s;
		s = new FixedCapacityStackOfStrings(100);
		s.push("hello");
		s.push("world");
		s.push("!");
		System.out.println(s.pop() + " " + s.pop() + " " + s.pop());
	}
}
