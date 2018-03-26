package base;
import java.util.Iterator;
/***API:
 * <ol>
 * <li>StackOfStrings(int cap):创建容量为cap的空栈
 * <li>push(String item):添加item
 * <li>pop():删除最近添加的字符串
 * <li>isEmpty():栈是否为空
 * <li>size():字符串数量
 * </ol>
 * 
 * 可动态调整数组大小,实现迭代功能
 * @author xzy
 *
 */
public class ArrayStack<Item> {

	private int N;
	private Item[]a;
	public ArrayStack(int cap)
	{a=(Item[])new Object[cap];}
	public boolean isEmpty() {return N==0;}
	public int size() {return N;}
	public void push(Item item) 
	{
		if(N==a.length)resize(2*N);
		a[N++]=item;
	}
	public Item pop() 
	{
		Item item=a[--N];
		a[N]=null;//避免对象游离
		if(N>0&&N==a.length/4)resize(a.length/2);
		return item; 
	}
	
	private void resize(int max)
	{
		Item[]temp=(Item[])new Object[max];
		for(int i=0;i<N;i++)
			temp[i]=a[i];
		a=temp;
	}
	
	public Iterator<Item>iterator()
	{return new ReverseArrayIterator();}
	private class ReverseArrayIterator implements Iterator<Item>
	{   //支持后进后出的迭代
		private int i=N;
		public boolean hasNext() {return i>0;}
		public Item next() {return a[--i];}
		public void remove() {}
	}
}
