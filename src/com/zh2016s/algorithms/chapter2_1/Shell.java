package com.zh2016s.algorithms.chapter2_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Shell {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
					exch(a, j, j - h);
			}
			h = h / 3;
		}
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i] + "");
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		FileInputStream is;
		try {
			is = new FileInputStream("algs4-data/tale.txt");
			Scanner sc = new Scanner(is);
			ArrayList<String> list = new ArrayList<String>();
			while(sc.hasNext())
				list.add(sc.next());
			String[] a = list.toArray(new String[list.size()]);
			sort(a);
			show(a);
			System.out.println(a.length);
			System.out.println(a[100000]);
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
