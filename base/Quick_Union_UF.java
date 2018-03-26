package base;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * 跟随连接找到一个指向自己的根节点
 * 
 * 在同一个连通分量中的所有触点在id[]中的值必须全部相同
 * union-find的API:	
 * UF(int N):以整数(0-N-1)初始化N个触点
 * void union(int p,int q):在q，p之间添加一条连接
 * int find(int p):p所在的分量的标识符
 * boolean connected(int p,int q):如果q和p存在于同一分量，返回true
 * int count():连通分量的数量
 */
public class Quick_Union_UF {
	
		private int[] id;//分量id(以触点作为索引)
		private int count;//分量的数量，并且每进行一次归并，分量总数减一
		
		public Quick_Union_UF(int N)
		{	//初始化
			count = N;
			id = new int[N];
			for(int i = 0;i < N;i++)
				id[i] = i;
		}
		
		public int count() {	return count;	}
		
		public boolean connected(int p,int q)
		{	return find(p) == find(q);	}
		
		public int find(int p) 
		{	
			while(p != id[p])p = id[p];
			return p;
		}
		
		public void union(int q,int p) 
		{
			int pRoot = find(p);
			int qRoot = find(q);
			
			if(pRoot == qRoot)return;
			
			id[pRoot] = qRoot;
			
			count--;
		}
		
		public static void main(String[]args) {
			
			int N = StdIn.readInt();//读取触点的数量
			
			Quick_Union_UF uf = new Quick_Union_UF(N);
			
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

