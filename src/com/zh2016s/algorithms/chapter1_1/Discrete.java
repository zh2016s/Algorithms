package com.zh2016s.algorithms.chapter1_1;

/**
 * 
 * @author zh2016s 
 * 根据离散概率随机返回int的值（出现i的概率为a[i]）
 *
 */
public class Discrete {
	public static int discrete(double[] a) {
		// a[]中各元素之和必须等于1
		double r = Math.random();
		double sum = 0.0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
			if (sum > r)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		double[] nums = { 0.1, 0.2, 0.3, 0.4 };
		int num0 = 0;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int a = 0;
		for (int i = 0; i < 10000; i++) {
			a = discrete(nums);
			if (a == 0)
				num0++;
			else if (a == 1)
				num1++;
			else if (a == 2)
				num2++;
			else
				num3++;
		}
		System.out.println(num0 + " " + num1 + " " + num2 + " " + num3 + " ");
	}
}
