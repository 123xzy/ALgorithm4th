package base;

import edu.princeton.cs.algs4.In;

public class TwoSum {

	public static int count(int[]a)
	{
		int cnt = 0;
		int len=a.length;
		for(int i = 0;i<len;i++)
			for(int j = i+1;j<len;j++)
				if(a[i]+a[j] == 0)cnt++;
		return cnt;
	}
	
	public static void main(String[]args)
	{
		@SuppressWarnings("deprecation")
		int[]a = In.readInts(args[0]);
		System.out.println(count(a));
	}
}
