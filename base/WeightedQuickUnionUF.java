package base;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
	
	private int[] id; 
	private int[] sz;//由触点索引的各个根节点所对应的分量的大小
	private int count;//连通分量的数量
	
	public WeightedQuickUnionUF(int N)
	{
		count = N;
		id = new int[N];
		for(int i = 0;i < N;i++)
			id[i] = i;
		sz = new int[N];
		for(int i = 0;i < N;i++)
			sz[i] = 1;
	}
	
	public int count()
	{	return count;	}
	
	public boolean connected(int p,int q)
	{	return find(p)  == find(q);	}
	
	public int find(int p)
	{
		while(p != id[p])p = id[p];
		return p;
	}
	
	public void union(int p,int q)
	{
		int i = find(p);
		int j = find(q);
		if(i == j)return;
		if(sz[i] < sz[j]) {	id[i] = j;sz[j] += sz[i];	}
		else {	id[j] = i;sz[i] += sz[j];	}
		count--;
	}
	
	public static void main(String[]args) {
		int N = StdIn.readInt();//读取触点的数量
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		while(!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(uf.connected(p, q))continue;//如果连通则忽略
			uf.union(q, p);
			StdOut.println(p + " " + q);//打印连接
		}
		StdOut.println(uf.count + "components");
	}
}
