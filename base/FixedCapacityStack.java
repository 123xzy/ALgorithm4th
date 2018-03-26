package base;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
 * 定容栈API：指定容量但支持泛型
 * FixedStackOfStrings(int cap):创建一个容量为cap的空栈
 * void push(Item item):添加一个字符串
 * Item pop():删除最近添加的字符串
 * boolean isEmpty():栈是否为空
 * int size():栈的字符串数量
 */
public class FixedCapacityStack<Item> {
	
	private Item[]a;
	private int N;
	
	public FixedCapacityStack(int cap)
	{	a = (Item[]) new Object[cap];	}
	
	public boolean isEmpty() {	return N==0;	}
	
	public int size() {return N;}
	
	public void push(Item item) {	a[N++] = item;	}
	
	public Item pop() {return a[--N];}
	
	public boolean isFull() {return N==100;}
	
	//测试用例
	public static void main(String[]args) 
	 {
		FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);
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
