package base;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
/*
 * 泛型可迭代的Stack数据类型的API：
 * Stack():创建一个空栈
 * void push(Item item):添加一个元素
 * Item pop():删除最近添加的元素
 * boolean isEmpty():栈是否为空
 * int size():栈的元素数量
 */
//链表实现的栈
public class Stack<Item> implements Iterable<Item>{

	private class Node//对用例来说是不可见的
	{
		Item item;
		Node next;
	}
	
	private Node first;
	private int N;
	
	public boolean isEmpty() {return first==null;}
	
	public int size() {return N;}
	
	public void push(Item item)
	{
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		N++;
	}
	
	public Item pop()
	{
		Item item=first.item;
		first=first.next;
		N--;
		return item;
	}
	
	public Iterator<Item>iterator(){	return new ListIterator();	}
	
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		public boolean hasNext() {	return current != null;	}
		public void remove() {}
		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	//测试用例
	public static void main(String[]args) 
	 {
		Stack s=new Stack();
		while(!StdIn.isEmpty())
		{
			String item=StdIn.readString();
			if(!item.equals("-"))
				s.push(item);
			else if(!s.isEmpty())StdOut.print(s.pop()+" ");
		}
		StdOut.println("("+s.size()+"left on stack)");
	}
}
