package com.zh2016s.algorithms.chapter1_1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author zh2016s 
 * 二分查找的循环实现
 *
 */
public class BinarySearch {

	public static int binarySearch(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("algs4-data/largew.txt");
			Scanner scanner = new Scanner(in);
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (scanner.hasNextInt())
				list.add(scanner.nextInt());
			int[] nums = list.stream().mapToInt(Integer::valueOf).toArray();
			Arrays.sort(nums);
			int key = 803531;
			System.out.println(binarySearch(key, nums));
			scanner.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
