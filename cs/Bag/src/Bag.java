//Ryan Carey, generic bag
public interface Bag {
	void add(Object e);
	void addAll();
	Bag clone();
	int countOccurrences(Object target);
	void ensureCapacity(int minimumCapacity);
	int getCapacity();
	void remove();
	int size();
	void trimToSize();
	Bag union(Bag a, Bag b);
	
}
