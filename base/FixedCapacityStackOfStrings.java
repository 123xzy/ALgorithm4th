package base;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/*
 * 定容栈API：指定容量且不支持迭代
 * FixedStackOfStrings(int cap):创建一个容量为cap的空栈
 * void push(String item):添加一个字符串
 * String pop():删除最近添加的字符串
 * boolean isEmpty():栈是否为空
 * int size():栈的字符串数量
 */
public class FixedCapacityStackOfStrings {

	private String[]a;
	private int N;
	
	public FixedCapacityStackOfStrings(int cap)
	{a=new String[cap];}
	
	public boolean isEmpty() {return N==0;}
	
	public int size() {return N;}
	
	public void push(String item) {a[N++]=item;}
	
	public String pop() {return a[--N];}
	
	public boolean isFull() {return N==100;}
	
	//测试用例
	public static void main(String[]args) 
	 {
		FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
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
