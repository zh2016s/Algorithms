package com.zh2016s.algorithms.chapter1_1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author zh2016s 
 * 二分查找的递归实现
 * 
 */
public class BinarySearchRecursion {
	public static int binarySearch(int key, int[] a, int lo, int hi) {
		if (lo > hi)
			return -1;
		int mid = (lo + hi) / 2;
		if (key < a[mid])
			return binarySearch(key, a, lo, mid - 1);
		else if (key > a[mid])
			return binarySearch(key, a, mid + 1, hi);
		else
			return mid;
	}

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("algs4-data/largew.txt");
			Scanner sc = new Scanner(is);
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (sc.hasNextInt())
				list.add(sc.nextInt());
			int[] nums = list.stream().mapToInt(Integer::valueOf).toArray();
			Arrays.sort(nums);
			System.out.println(binarySearch(803531, nums, 0, nums.length - 1));
			sc.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
