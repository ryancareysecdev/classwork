//Ryan Carey, IntArrayBag, rather inefficient, but working implementation

public class IntArrayBag extends java.lang.Object implements java.lang.Cloneable{
	private int[] IntArray;
	private int currsize;
	public IntArrayBag() {
		IntArray = new int[10];
		currsize=0;
	}
	public IntArrayBag(int InitialCapacity) {
		IntArray = new int[InitialCapacity];
		currsize=0;
	}
	public void add(int element) {
		if (size() <= getCapacity()) {
			IntArray[size()] = element;
			currsize++;
		}
		else {
			ensureCapacity(getCapacity()+20);
			add(element);
		}
		
	}
	public void addAll(IntArrayBag addend) {
		if ((this.size() + addend.size()) <= this.getCapacity()) {
			for (int lookingat : addend.IntArray) {
				if (lookingat != 0) {
					this.add(lookingat);
				}
			}
		}
		else {
			this.ensureCapacity(this.getCapacity()+20);
			this.addAll(addend);
		}
	}
	public void addMany(int... element) {
		if ((size() + element.length) <= this.getCapacity())
			for (int tempelement : element) {
				add(tempelement);
			}
		else {
			ensureCapacity(getCapacity()+20);
			addMany(element);
		}
	}
	@Override public IntArrayBag clone(){
		IntArrayBag clonedBag = new IntArrayBag(this.getCapacity()+1);
		clonedBag.addAll(this);
		return clonedBag;
	}
	public int countOccurrences(int searchingfor) {
		int numberfound = 0;
		for (int lookingat : this.IntArray) {
			if (lookingat == searchingfor) {
				numberfound++;
			}
		}
		return numberfound;
	}
	public void ensureCapacity(int minimumCapacity) {
		IntArrayBag backup = this.clone();
		this.IntArray = new int[minimumCapacity];
		this.currsize=0;
		this.addAll(backup);
	}
	public int getCapacity() {
		return IntArray.length;
	}
	public boolean remove(int takemeout) {
		boolean testing = false;
		for (int i = 0; i < this.size(); i++) {
			if (IntArray[i] == takemeout){
				while (i < (this.getCapacity()-1)) {
					IntArray[i] = IntArray[i+1];
					i++;
				}
				testing = true;
			}
				
		}
		if (testing == true) {
			IntArray[getCapacity()-1]=0;
			currsize--;
		}
		return testing;
	}
	public int size() {
		return currsize;
	}
	public void trimToSize() {
		IntArrayBag backup = this.clone();
		IntArray = new int[this.size()];
		currsize=0;
		addAll(backup);
	}
	@Override public String toString() {
		String returnme;
		returnme = "Capacity of: "+getCapacity()+ "\n";
		for (int lookingat : IntArray) {
			returnme = returnme + " " + lookingat;
		}
		return returnme;
	}
	public static IntArrayBag union(IntArrayBag a, IntArrayBag b) {
		IntArrayBag unionized = new IntArrayBag(a.size() + b.size());
		unionized.addAll(a);
		unionized.addAll(b);
		return unionized;
	}
	public static void main(String[] args) {
		IntArrayBag testcase1 = new IntArrayBag(5);
		IntArrayBag testcase2 = new IntArrayBag(4);
		testcase1.addMany(3, 4, 7, 9, 15);
		System.out.println(testcase1);
		testcase2.addMany(77, 13, 93, 11, 8);
		System.out.println(testcase2);
		IntArrayBag uni = union(testcase1, testcase2);
		System.out.println(uni);
		uni.remove(9);
		System.out.println(uni);
		uni.trimToSize();
		System.out.println(uni);
	}

}
