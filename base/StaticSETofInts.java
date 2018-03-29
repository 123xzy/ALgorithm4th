package base;
import java.util.Arrays;
/**
 * 将二分查找重写为一段面对对象的程序，用于在整数集合中进行查找的一种抽象数据类型
 * API
 * StaticSETofInts(int[] a)：根据a[]中的值创建一个集合
 * boolean contains(int key):key是否存在于集合中
 * @author xzy
 *
 */
public class StaticSETofInts {
	private int[] a;
	public StaticSETofInts(int[] keys) {
		int len = keys.length;
		a = new int[len];
		//保护性复制，但会损失一定线性的效率
		for(int i = 0;i < len;i++)
			a[i] = keys[i];
		//二分查找的前提
		Arrays.sort(a);
	}
	
	/**
	 * key是否存在于集合中，并使用内部方法search
	 * 
	 * @param key
	 * @return
	 */
	public boolean contains(int key)
	{	return search(key);	}
	
	/**
	 * 利用二分查找key
	 * 
	 * @param key
	 * @return true表示存在，false表示不存在
	 */

	private boolean search(int key) {
		int hi = a.length - 1;
		int lo = 0;
		while(lo <= hi) {
			int mid = (hi + lo) / 2;
			if(key < a[mid]) hi = mid - 1;
			else if(key > a[mid]) lo = mid + 1;
			else return true;
		}
		return false;
	}
}
