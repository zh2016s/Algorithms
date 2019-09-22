package com.zh2016s.algorithms.chapter1_1;

/**
 * 
 * @author zh2016s 
 * 欧几里得算法，计算两个非负整数的最大公约数
 * 
 */
public class Gcd {

	public static int gcd(int p, int q) {
		if (q == 0)
			return p;
		int r = p % q;
		return gcd(q, r);
	}

	public static void main(String[] args) {
		System.out.println(gcd(15, 115));
	}
}