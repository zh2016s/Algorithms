package com.zh2016s.algorithms.chapter1_4;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreeSum {
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++)
				for (int k = j + 1; k < N; k++)
					if (a[i] + a[j] + a[k] == 0)
						cnt++;
		return cnt;
	}

	public static void main(String[] args) {
		try {
			FileInputStream in = new FileInputStream("algs4-data/1kints.txt");
			Scanner sc = new Scanner(in);
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (sc.hasNextInt()) {
				list.add(sc.nextInt());
			}
			int[] nums = list.stream().mapToInt(Integer::valueOf).toArray();
			System.out.println(count(nums));
			sc.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
