package com.zh2016s.algorithms.chapter1_3;

public class AutoIncrementStack<T> {
	private T[] a;
	private int N;
	@SuppressWarnings("unchecked")
	public AutoIncrementStack() {
		a = (T[])new Object[10];
	}
	public boolean isEmpty() {
		return N==0;
	}
	public int size() {
		return N;
	}
	public void push(T t) {
		if(N==a.length) resize(2*a.length);
		a[N++]=t;
	}
	public T POP() {
		T t = a[--N];
		a[N]=null;
		if(N>0&&N==a.length/4) resize(a.length/2);
		return t;
	}
	public void resize(int max) {
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[max];
		for(int i =0;i<N;i++)
			temp[i]=a[i];
		a=temp;
	}
	public static void main(String[] args) {
		AutoIncrementStack<String> s = new AutoIncrementStack<String>();
		s.push("hello");
		s.push("world");
		s.push("!");
		System.out.println(s.POP()+" "+s.POP()+" "+s.POP());
	}
}
