package base;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
/**
 * 作为StaticSETofInts的用例
 * @author xzy
 *
 */
public class Whitelist {
	public static void main(String[]args) {
		int[] a = In.readInts(args[0]);
		int count = 0;
		//创建白名单
		StaticSETofInts set = new StaticSETofInts(a);
		while(!StdIn.isEmpty())
		{
			//读取键，如果不在白名单，则打印
			int key = StdIn.readInt();
			if(!set.contains(key))
			{
				count++;
				System.out.println(key);
			}
		}
		//System.out.println(count);
	}
}
