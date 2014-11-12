import java.util.*;

class LinkedListArr
{
	private int size;
	private static int capacity = 20;
	private int[] ListArray;
	
	public LinkedListArr()
	{
		size = 0;
		ListArray = new int[capacity];
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	public boolean isFull()
	{
		return size == capacity;
	}
	
	public void insertFirst(int value)
	{
		if(isFull())
			throw new ArrayIndexOutOfBoundsException();
		for(int i = size; i > 0; i--)
			ListArray[i] = ListArray[i-1];
		ListArray[0] = value;
		size++;
	}
	public void insertAt(int index, int value)
	{
		if(isFull())
			throw new ArrayIndexOutOfBoundsException();

		for(int i = size; i >= index; i--)
			ListArray[i] = ListArray[i-1];
		ListArray[index] = value;
		size++;
	}
	
	public void insertLast(int value)
	{
		if(isFull())
			throw new ArrayIndexOutOfBoundsException();
		ListArray[size] = value;
		size++;
	}
	
	public int removeFirst()
	{
		if(isEmpty())
			throw new ArrayIndexOutOfBoundsException();

		int temp = ListArray[0];
		for(int i = 0; i < size; i++)
			ListArray[i] = ListArray[i+1];
		size--;
		System.out.print("Removed Element: " + temp + "\n");
		System.out.println(" ");
		return temp;
		
	}
	
	public int removeAt(int index) 
	{
		if(isEmpty())
			throw new ArrayIndexOutOfBoundsException();

		int temp = ListArray[index];
		for(int i = index; i < size; i++)
			ListArray[i] = ListArray[i+1];
		size--;
		System.out.print("Removed Element: " + temp + "\n");
		System.out.println(" ");
		return temp;
	}
	
	public int removeLast()
	{
		if(isEmpty())
			throw new ArrayIndexOutOfBoundsException();

		int temp = ListArray[size-1];
		size--;
		System.out.print("Removed Element: " + temp + "\n");
		System.out.println(" ");
		return temp;
	}
	
	public void display()
	{
		System.out.println("Linked List: ");
		for(int i = 0; i < size; i++)
			System.out.print(ListArray[i] + " ");
		
		System.out.println("\nSize of Linked List: " +size);
		System.out.println(" ");
	}
	
}


public class LinkedListArray {

	public static void main(String argv[])
	{
		LinkedListArr lla = new LinkedListArr();
		lla.insertLast(10);
		lla.insertLast(20);
		lla.insertLast(30);
		lla.insertFirst(60);
		lla.display();
		lla.size();
		
		lla.insertAt(2, 110);
		lla.insertFirst(89);
		lla.display();
		lla.insertLast(70);
		lla.insertAt(5, 4);
		lla.display();
		
		lla.removeLast();
		lla.display();
		
		lla.removeAt(2);
		lla.display();

		lla.removeFirst();
		lla.display();
	}
}
