import java.util.*;
public class LinkedBag implements Bag{
	private LinkedList<Integer> backList;
	private Iterator<LinkedList> itr = backList.iterator();

	@Override
	public void add(Object e) {
		itr.add(e);
		
	}

	@Override
	public void addAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countOccurrences(Object target) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ensureCapacity(int minimumCapacity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void trimToSize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bag union(Bag a, Bag b) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
