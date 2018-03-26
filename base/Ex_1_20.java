package base;
import java.util.*;
/**
 * 递归计算ln(!N)
 * 
 * @author lenovo
 *
 */
public class Ex_1_20 {

	public static int factorial(int N)
	{
		if(N==1)return 1;
		return factorial(N-1)*N;
	}
	public static void main(String[]args) {
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		System.out.println(Math.log(factorial(N)));
	}
}
