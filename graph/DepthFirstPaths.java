package graph;
import base.Stack;
import edu.princeton.cs.algs4.*;
/*
 * API:
 * DepthFirstPaths(Graph G,int s):在G中找出所有起点为s的路径
 * boolean hasPathTo(int v):是否存在从s到v的路径
 * Stack<Integer>pathTo(int v):s到v的路径，如果不存在则返回null
 */
public class DepthFirstPaths 
{
	private boolean[] marked;
//edgeTo[w] = v表示v-w是第一次访问w时经过的边； edgeTo[]数组是一棵用父链接表示以s为根且含有所有与s连通顶点的树
	private int[] edgeTo;
	private final int s;//起点
	
	public DepthFirstPaths(Graph G,int s)
	{
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G,s);
	}
	
	private void dfs(Graph G,int v)
	{
		marked[v] = true;
		for(int w : G.adj(v))
			if(!marked[w])
			{
				edgeTo[w] = v;
				dfs(G,w);
			}
	}
	
	public boolean hasPathTo(int v)
	{	return marked[v];	}
	
	public Iterable<Integer> pathTo(int v)
	{
		if(!hasPathTo(v))return null;
		Stack<Integer>path = new Stack<Integer>();
		for(int x = v;x != s;x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
	
	//测试用例
	public static void main(String[]args)
	{
		Graph G = new Graph(new In(args[0]));
		int s = Integer.parseInt(args[1]);
		DepthFirstPaths search = new DepthFirstPaths(G,s);
		for(int v = 0;v < G.V();v++)
		{
			StdOut.print(s + "to" + v + ":");
			if(search.hasPathTo(v))
				for(int x : search.pathTo(v))
					if(x == s)StdOut.print(x);
				else StdOut.print("-" + x);
			StdOut.print();
		}
	}
}
