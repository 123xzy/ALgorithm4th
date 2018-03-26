/*
 * n²级别的ThreeSum算法
 */
package base;

import java.util.Arrays;
import edu.princeton.cs.algs4.In;

public class ThreeSumFaster {

	public static int count(int[]a)
	{
		int len = a.length-1;
		int cnt = 0;
		int end = len;
		
		Arrays.sort(a);
		for(int i = 0;i<=len;i++)
		{
			int begin = i+1;
			
			while(begin<end)
			{
				if((a[begin]+a[end]+a[i]) == 0)
				{
					begin++;end--;
					cnt++;
					while (begin<end&&a[end] == a[end--]) {cnt++;}
	    			while (begin<end&&a[begin] == a[begin++]) {cnt++;}
				}
				else 
				{
					if((a[begin]+a[end]+a[i]) > 0)
						end--;
					else 
						begin++;
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[]args)
	{
		@SuppressWarnings("deprecation")
		int[]a = In.readInts(args[0]);
		System.out.println(count(a));
	}
}
