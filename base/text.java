package base;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class text {
	public static void main(String[]args) {
		Queue<String>s=new Queue<String>();
		while(!StdIn.isEmpty())
		{
			String item=StdIn.readString();
			if(!item.equals("-"))
				s.enqueue(item);
			else if(!s.isEmpty())StdOut.print(s.dequeue()+" ");
		}
		StdOut.println("("+s.size()+"left on stack)");
	}
}
