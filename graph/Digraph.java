package graph;
import base.Bag;
import edu.princeton.cs.algs4.In;
/*
 * Digarph API：
 * Graph(int V):创建一个含有V个顶点但不含边的图
 * Graph(In in):从标准输入流读取一幅图
 * int V():     定点数
 * int E():		边数
 * void addEdge(int v,int w):向图中添加一条边v-w
 * Iterable<Integer> adj(int v):和v相邻的所有顶点
 * Digraph reverse():反向图
 * String toString():对象的字符串表示
 */
public class Digraph {
	private final int V;
	private int E;
	private Bag<Integer>[]adj;
	
	public Digraph(int V)
	{
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];
		for(int v = 0;v < V;v++)
			adj[v] = new Bag<Integer>();
	}
	public Digraph(In in)
	{
		this(in.readInt());				 //读取V并将图初始化
		int E = in.readInt();			 //读取E
		for(int i = 0;i < E;i++)
		{
			int v = in.readInt();		 //读取一个顶点
			int w = in.readInt();		//读取另一个顶点
			addEdge(v,w); 				//添加一条连接他们的边
		}
	}
	
	public int V() { return V; }
	public int E() { return E; }
	
	public void addEdge(int v,int w)
	{
		adj[v].add(w);
		E++;
	}
	
	public Iterable<Integer>adj(int v)
	{	return adj[v];	}
	
	public Digraph reverse()
	{
		Digraph R = new Digraph(V);
		for(int v = 0;v < V;v++)
			for(int w : adj(v))
				R.addEdge(w, v);
		return R;
	}
	
	public String toString() {
		String s = V + "vertices," + E + " edges\n";
		for(int v = 0;v < V;v++)
		{
			s += v + ": ";
			for(int w : this.adj(v))
				s += w + " ";
			s += "\n";
		}
		return s;
	}
}






