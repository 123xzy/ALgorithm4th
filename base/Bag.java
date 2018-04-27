package base;
import java.util.Iterator;
/*
 * 泛型可迭代的Bag数据类型的API 
 * Bag()：创建一个空背包
 * void add(Item item)：添加元素
 * boolean isEmpty():是否为空背包
 * int size():元素数量
 */
public class Bag<Item> implements Iterable<Item> 
{
	private Node first;
	private int N;
	private class Node
	{
		Item item;
		Node next;
	}
	public void add(Item item)
	{
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		N++;
	}
	
	public int size(){	return N;	}
	
	public Iterator<Item>iterator()
	{	return new ListIterator();	}
	
	private class ListIterator implements Iterator<Item>
	{
		private Node current=first;
		public boolean hasNext()
		{return current!=null;}
		public void remove() {}
		public Item next()
		{
			Item item=current.item;
			current=current.next;
			return item; 
		}
	}
}
