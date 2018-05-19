package Search;

/**
 * SeparateChain of HashTable
 * @author xzy
 *
 */
public class SeparateChainingHashST<Key,Value> {
	/* sum of key-value */
	private int N; 
	/* size of hash table */
	private int M;
	/* array to store key-value */
	private SequentialSearchST<Key, Value>[] st;
	
	/* Strucrture a linked list size of M */
	public SeparateChainingHashST(int M) {
		this.M = M;
		st = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];
		for(int i = 0;i < M;i++)
			st[i] = new SequentialSearchST();
	}
	
	/* create a hashtable size 997 */
	public SeparateChainingHashST()
	{	this(997);	}
	
	/* hash function */
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;	
	}
	
	/* get value of key */
	public Value get(Key key) {
		return (Value)st[hash(key)].get(key);
	}
	
	/* store a key-value */
	public void put(Key key,Value value) {
		st[hash(key)].put(key, value);
	}
	
	
	public Iterable<Key> keys(){
		
	}
	
}
