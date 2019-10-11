package com.zh2016s.algorithms.chapter1_4;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.zh2016s.algorithms.chapter1_1.BinarySearch;

/**
 * 
 * @author aaoomm
 * 2-sum问题的线性对数级别的解法
 *
 */
public class TwoSumFast {
	public static int count(int[] a) {
		//计算和为0的整数对的数目
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for(int i=0;i<N;i++)
			if(BinarySearch.binarySearch(-a[i], a)>i)
				cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		FileInputStream is;
		try {
			is = new FileInputStream("algs4-data/1kints.txt");
			Scanner sc = new Scanner(is);
			ArrayList<Integer> list = new ArrayList<Integer>();
			while(sc.hasNextInt())
				list.add(sc.nextInt());
			int[] nums = list.stream().mapToInt(Integer::valueOf).toArray();
			System.out.println(count(nums));
			is.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
