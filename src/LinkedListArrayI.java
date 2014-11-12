
// Implementation of Linked List using Iterator 

class LinkedListA<T> implements Iterable<T> {

	private static int DEFAULT_CAPACITY = 10;	
	
	private int size;
	private T[] item;
	
	public LinkedListA()
	{
		size = 0;
		ensureCapacity(size());
	}
	
	public void clear()
	{
		size = 0;
		ensureCapacity(size());
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	public void trimToSize()
	{
		ensureCapacity(size());
	}
	
	public T get(int index)
	{
		if(index < 0 || index > size())
			throw new ArrayIndexOutOfBoundsException();
		return item[index];
	}
	
	public T set(T newValue, int index)
	{
		if(index < 0 || index > size())
			throw new ArrayIndexOutOfBoundsException();
		T old = item[index];
		item[index] = newValue;
		return old;
	}
	
	public void ensureCapacity(int newCapacity)
	{
		if(newCapacity < size)
			return;
		T[] old = item;
		item = (T [])new Object[newCapacity];
		for(int i = 0; i < newCapacity; i++)
			item[i] = old[i];
			
	}
	public void display()
	{
		for(int i = 0; i < size() - 1; i++)
			System.out.print(item[i]);
	}
	public boolean add(T value)
	{
		add(size(), value);
		return true;
	}
	public void add(int index, T value)
	{
		if(item.length == size())
			ensureCapacity(size() *2 +1);
		for(int i = size(); i > index; i--)
			item[i] = item[i-1];
		item[index] = value;
			
		size++;
	}
	
	public T remove(int index)
	{
		T removedElement = item[index];
		for(int i = index; i<= size() - 1; i++)
			item[i] = item[i+1];
		size--;
		return removedElement;
	}
	
	public java.util.Iterator<T> iterator()
	{
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements java.util.Iterator<T>
	{
		private int current;
		
		public boolean hasNext()
		{
				return current< size();
		}
		
		public T next()
		{
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			return item[current++];
		}
		
		public void remove()
		{
			LinkedListA.this.remove(--current);
		}
	}
}
public class LinkedListArrayI
{
	public static void main(String argv[])
	{
		LinkedListA la = new LinkedListA();
		la.add(0, 10);
		la.add(1, 52);
		la.add(2, 85);
		la.add(3, 63);
		la.add(4, 9);
		
		la.display();
		
	}

}
