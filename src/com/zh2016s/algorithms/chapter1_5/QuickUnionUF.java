package com.zh2016s.algorithms.chapter1_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class QuickUnionUF {
	private int[] id; //分量id
	private int count;	//分量数量
	public QuickUnionUF(int N) {
		id = new int[N];
		count = N;
		for(int i = 0;i<N;i++)
			id[i]=i;
	}
	public int count() {
		return count;
	}
	public boolean connected(int p, int q) {
		return find(p)==find(q);
	}
	public int find(int p) {
		while(id[p]!=p)
			p=id[p];
		return p;
	}
	public void union(int p,int q) {
		int pRoot= find(p);
		int qRoot = find(q);
		if(pRoot==qRoot) return;
		id[pRoot] = qRoot;
		count--;
	}
	public static void main(String[] args) {
		try {
			FileInputStream is = new FileInputStream("algs4-data/tinyUF.txt");
			Scanner sc = new Scanner(is);
			int N = sc.nextInt();
			QuickUnionUF uf = new QuickUnionUF(N);
			while(sc.hasNextInt()) {
				int pID = sc.nextInt();
				int qID = sc.nextInt();
				if(uf.connected(pID, qID))
					continue;
				uf.union(pID,qID);
				System.out.println(pID+" "+qID);
			}
			System.out.println(uf.count +" components");
			is.close();
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
