package Search;
/*
 * 泛型符号表API:
 * ST():创建一张符号表
 * void put(Key key,Value value):将键值对存入表中(如果key为空则将key从表中删除)
 * Value get(Key key):获取键key对于的值(如果键key不存在则返回null)
 * void delete(Key key):从表中删除key(及其对于的值)
 * boolean contians(Key key):键key在表中是否有对于的值
 * boolean isEmpty():表是否为空
 * int size():表中的键值对数量
 * Iterable<Key> keys():表中所有键的集合
 * key min():最小的键
 * key max():最大的键
 * key floor(Key key):小于等于key的最大键
 * key ceiling(Key key):大于等于key的最小键
 * int rank(Key key):小于key的键的数量
 * Key select(int k):排名为k的键
 * void deleteMin():删除最小的键
 * void deleteMax():删除最大的键
 * int size(Key lo,Key hi):[lo,hi]之间的键的数量
 * Iterable<key> keys(Key lo,Key hi):[lo,hi]之间的所有键，已排序
 * Iterable<key> keys():表中的所有键的集合，已排序 
 */
public class ST<Key,> {
	void delete(Key key) {	put(key,null);	}
	boolean contains(Key key) {	return get(key) != null;	}
	boolean isEmpty() {	return size() == 0;	}
	void deleteMin() {	delete(min());	}
	void deleteMax() {	delete(max());	}
	int size(Key lo,Key hi)
	{
		if(hi.compareTo(To) < 0)
			return 0;
		else if (contains(hi))
			return rank(hi) - rank(lo) + 1;
		else 
			return rank(hi) - rank(lo);
	}
	Iterable<Key> keys(){	return keys(min(),max());	}
}
