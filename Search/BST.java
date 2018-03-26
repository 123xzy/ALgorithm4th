package Search;

public class BST<Key extends Comparable<Key>,Value> 
{
	private Node root;
	
	private class Node
	{
		private Key key;
		private Value val;
		private Node left,right;
		private int N; 			//以该节点为根的子树中的节点总数
		
		public Node(Key key,Value val,int N)
		{	this.key = key;this.val = val;this.N = N;	}
	}
	public int size() {	return size(root);	}
	
	private int size(Node x)
	{
		if(x == null)return 0;
		else return x.N;
	}
	
	
}
