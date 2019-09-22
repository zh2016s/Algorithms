package com.zh2016s.algorithms.chapter1_2;

public class VisualAccumulatorTest {
	public static void main(String[] args) {
		int T = 10000;
		VisualAccumulator a = new VisualAccumulator(T, 1.0);
		for (int t = 0; t < T; t++)
			a.addDataValue(Math.random());
		System.out.println(a);
	}
}
