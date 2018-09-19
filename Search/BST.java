package Search;
/*
 * 二叉查找树的实现
 */

public class BST<Key extends Comparable<Key>,Value> 
{
	private Node root;			//二叉树的根节点
	
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
	
	/* 查找 */
	public Value get(Key key)
	{
		return get(root,key);
	}	
	
	private Value get(Node x,Key key)
	{
		if(x == null)return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)return get(x.right,key);
		else if(cmp > 0)return get(x.left, key);
		else return x.val;
	}
	
	/* 插入
	 * 如果key存在则更新值，否则创建一个新节点，并连接到树上 */
	public void put(Key key,Value value)
	{
		root = put(root, key,value);
	}
	
	private Node put(Node x,Key key,Value value)
	{
		if(x == null)return new Node(key, value, 1);
		int cmp = key.compareTo(x.key);
		if(cmp < 0)x.left = put(x.left, key, value);
		else if(cmp > 0)x.right = put(x.right, key, value);
		else x.val = value;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}	
	
	/* 删除最小值 */
	public void deleteMin()
	{
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x)
	{
		if(x.left == null)return x.right;	//该节点会自动被回收
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void delete(Key key)
	{
		root = delete(root,key);
	}
	
	private Node delete(Node x,Key key)
	{
		if(x == null)return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)x.left = delete(x.left,key);
		else if(cmp > 0)x.right = delete(x.right, key);
		else {
			/* 该节点只有一个子节点 */
			if(x.left == null)return x.right;
			if(x.right == null)return x.left;
			
			/* 该节点有两个子节点，就需要找后继节点替代 */
			Node tNode = x;
			x = min(tNode.right);
			x.right = deleteMin(tNode.right);
			x.left = tNode.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	/* 最大值 */
	public Key min()
	{
		return min(root).key;
	}
	
	private Node min(Node x)
	{
		if(x.left == null)return x;
		return min(x.left);
	}

}
