/*
 * 增长数量级N²logN
 * 将数组排序，并进行N(N-1)/2次二分查找，每次查找所需时间和logN成正比
 * 
 */

package base;
import java.util.Arrays;
import edu.princeton.cs.algs4.In;

public class ThreeSumFast 
{

	public static int count(int[]a)
	{
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for(int i = 0;i < N;i++)
			for(int j = i+1;j<N;j++)
				if(BinarySearch.rank(-a[i]-a[j], a)>j)
					cnt++;
		return cnt;
	}
	
	public static void main(String[]args) 
	{
		@SuppressWarnings("deprecation")
		int[]a = In.readInts(args[0]);
		System.out.println(count(a));
	}
}
