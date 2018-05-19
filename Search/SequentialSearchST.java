package Search;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import base.Queue;

/**
 * 
 * @author xzy
 *
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key,Value>
{
	private Node first;
	
	private class Node
	{
		Key key;
		Value val;
		Node next;
		
		public Node(Key key,Value val,Node next)
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public Value get(Key key)
	{
		for(Node x = first;x != null;x = x.next)
			if(key.equals(x.key))
				return x.val;
		return null;
	}
	
	public void put(Key key,Value val)
	{
		for(Node x = first;x != null;x = x.next)
			if(key.equals(x.key))
			{	x.val = val;return;	}
		first = new Node(key,val,first);
	}
	public boolean contains(Key key) {
		return get(key) != null;
	}
	
	public Iterable<Key> keys()
	{
		Queue<Key> q = new Queue<Key>();
		for(Node x = first;x != null;x = x.next)
			q.enqueue(x.key);
		return q;
	}
	
	public static void main(String[]args)
	{
		SequentialSearchST<String,Integer> st = new SequentialSearchST<String,Integer>();
		
		for(int i = 0;!StdIn.isEmpty();i++)
		{
			String key = StdIn.readString();
			st.put(key, i);
		}
		
		for(String s : st.keys())
			StdOut.println(s + " " + st.get(s));
	}
	
}
