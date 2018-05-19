package Search;

/**
 * List API of character table
 * @author xzy
 *
 * @param <Key>
 * @param <Value>
 */
public class ST<Key extends Comparable<Key>,Value> {
	
	/* Create a symbol table */
	public ST() {
		
	}
	
	/* Put value with key into table,if value is null delete this key */
	void put(Key key,Value value) {	
		/* Not allow null value */
		if(value == null) {	delete(key);return;	}
		
	}
	
	/* Gain the value of a key,if key not exit return null */
	Value get(Key key) {	

	}
	
	/* Delete key and value from table */
	void delete(Key key) {
		put(key, null);
	}
	
	/* If key has its corresponding value in table */
	boolean contains(Key key) {
		return get(key) != null;
	}
	
	/* If table is empty */
	boolean isEmpty() {	
		return size() == 0;	
	}
	
	/* Quantity of Key-value */
	int size(){
		
	}
	
	/* Mininum of value */
	Key min() {
		
	}
	
	/* Maximum of value */
	Key max() {
		
	}
	
	/* Maximum of key less than or equal to key */
	Key floor(Key key) {
		
	}
	
	/* Mininum of key more than or equal to key */
	Key ceiling(Key key) {
		
	}
	
	/* Quantity of key less than key */
	int rank(Key key) {
		
	}
	
	/* Key ranking for k */
	Key select(int k) {
		
	}
	
	/* delete mininum of key */
	void deleteMin() {	
		delete(min());	
	}
	
	/* delete manimum of key */
	void deleteMax() {	
		delete(max());	
	}
	
	/* Quantity of key between lo and hi */
	int size(Key lo,Key hi) {
		
	}
	
	/* Set of all keys sorted between lo and hi*/
	Iterable<Key> keys(Key lo,Key hi){	
		
	}
	
	/* Set of all keys sorted */
	Iterable<Key> keys(){	
		
	}

}
