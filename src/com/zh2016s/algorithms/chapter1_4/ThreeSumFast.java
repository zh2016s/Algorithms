package com.zh2016s.algorithms.chapter1_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.zh2016s.algorithms.chapter1_1.BinarySearch;


public class ThreeSumFast {
	public static int count(int[] a) {
		//计算和为0的三元组的数目
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for(int i =0;i<N;i++)
			for(int j =i;j<N;j++)
				if(BinarySearch.binarySearch(-a[i]-a[j], a)>j)
					cnt++;
		return cnt;
	}
	public static void main(String[] args) {
		try {
			FileInputStream is = new FileInputStream("algs4-data/1kints.txt");
			Scanner sc = new Scanner(is);
			ArrayList<Integer> list = new ArrayList<Integer>();
			while(sc.hasNextInt())
				list.add(sc.nextInt());
			int[] nums = list.stream().mapToInt(Integer::valueOf).toArray();
			System.out.println(count(nums));
			sc.close();
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
