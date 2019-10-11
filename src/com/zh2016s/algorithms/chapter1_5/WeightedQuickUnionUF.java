package com.zh2016s.algorithms.chapter1_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WeightedQuickUnionUF {
	private int[] id; // 父链接数组(由触点索引)
	private int[] sz; // (由触点索引的)各个根节点所对应的分量的大小
	private int count; // 联通分量的数量

	public WeightedQuickUnionUF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++)
			sz[i] = 1;
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int find(int p) {
		while (p != id[p])
			p = id[p];
		return p;
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}
	public static void main(String[] args) {
		try {
			FileInputStream is = new FileInputStream("algs4-data/tinyUF.txt");
			Scanner sc = new Scanner(is);
			int N = sc.nextInt();
			WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
			while(sc.hasNextInt()) {
				int pID = sc.nextInt();
				int qID = sc.nextInt();
				if(uf.connected(pID,qID))
					continue;
				uf.union(pID, qID);
				System.out.println(pID+" "+qID);
			}
			System.out.println(uf.count +" components");
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
