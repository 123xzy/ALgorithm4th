package graph;
import base.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
/**Graph数据类型：
 * 采取邻接表来表示一幅图，并用Bag抽象数据类型来实现链表
 * 
 * 性能特点：
 * 		使用空间与V+E成正比
 * 		添加一条边时间为常数
 * 		遍历顶点的相邻顶点和顶点的度数成正比 
 * 
 *无向图的API：
 *Graph(int V):					创建一个含有V个顶点但不含边的图
 *Graph(In in):					从标准输入流读取一幅图
 *int V():						定点数
 *int E():						边数
 *void addEdge(int v,int w):	向图中添加一条边v-w
 *Iterable<Integer> adj(int v): 和v相邻的所有顶点
 *String toString():			对象的字符串表示
 */
public class Graph 
{
	private final int V;				 //顶点数目
	private int E; 						 //边的数目
	private Bag<Integer>[]adj;			 //邻接表
	
	public Graph(int V)
	{
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];//创建链表
		for(int v = 0;v < V;v++)		 //链表初始化
			adj[v] = new Bag<Integer>();
	}
	public Graph(In in)
	{
		this(in.readInt());				 //读取V并将图初始化
		int E = in.readInt();			 //读取E
		for(int i = 0;i < E;i++)
		{
			int v = in.readInt();		 //读取一个顶点
			int w = in.readInt();		 //读取另一个顶点
			addEdge(v,w); 				 //添加一条连接他们的边
		}
	}
	
	public int V() {return V;}
	public int E() {return E;}
	
	public void addEdge(int v,int w)
	{
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public Iterable<Integer>adj(int v){	return adj[v];	}
	
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
	
	public static void main(String[]args)
	{
		In in = new In(args[0]);
		Graph G = new Graph(in);
		StdOut.println(G);
	}
}
