package graph;

import edu.princeton.cs.algs4.In;

/*
 *用符号作为顶点名的图的API：
 *SymbolGraph(String filename,String delim):根据filename指定的文件构造图，使用delim来分隔顶点名
 *boolean contains(String key):key是一个顶点吗
 *int index(String key):key的索引
 *String name(int v):索引v的顶点名
 *Graph G():隐藏的Graph对象 
 */
public class SymbolGraph 
{
	private ST<String,Integer> st;//符号名->索引
	private String[] keys;        //索引->符号名
	private Graph G;
	
	public SymbolGraph(String stream,String sp)
	{
		st = new ST<String,Integer>();
		In in = new In(stream);
		while(in.hasNextLine())
		{
			String[] a = in.readLine().split(sp);//读取字符串
			for(int i = 0;i < a.length;i++)
				if(!st.contains(a[i]))
					st.put(a[i],st.size());
		}
		keys = new String[st.size()];
		
		for(String name : st.keys())
			keys[st.get(name)] = name;
		
		G = new Graph(st.size());
		in = new In(stream);
		while(in.hasNextLine())
		{
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for(int i = 1;i < a.length;i++)
				G.addEdge(v, st.get(a[i]));
		}
	}
	
	public boolean contains(String s) {	return st.contains(s);	}
	public int index(String s) {	return st.get(s);	}
	public String name(int v) {	return keys[v];	}
	public Graph G() {	return G;	}
}
