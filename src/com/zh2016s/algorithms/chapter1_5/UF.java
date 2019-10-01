package com.zh2016s.algorithms.chapter1_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//union-find的实现
public class UF {
	private int[] id;
	private int count;
	public UF(int N) {
		//初始化分量id数组
		count = N;
		id = new int[N];
		for(int i =0;i<N;i++)
			id[i] = i;
	}
	public int count() {
		return count;
	}
	public boolean connected(int p, int q) {
		return find(p)==find(q);
	}
	public int find(int p) {
		return id[p];
	}
	public void union(int p ,int q) {
		int pID=find(p);
		int qID=find(q);
		if(pID==qID)
			return;
		for(int i =0;i<id.length;i++)
			if(id[i]==pID)
				id[i]=qID;
		count--;
	}
	public static void main(String[] args) {
		try {
			FileInputStream is = new FileInputStream("algs4-data/tinyUF.txt");
			Scanner sc = new Scanner(is);
			int N = sc.nextInt();
			UF uf = new UF(N);
			while(sc.hasNextInt()) {
				int p = sc.nextInt();
				int q = sc.nextInt();
				if(uf.connected(p, q))
					continue;
				uf.union(p, q);
				System.out.println(p+" "+q);
			}
			System.out.println(uf.count+" components");
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
