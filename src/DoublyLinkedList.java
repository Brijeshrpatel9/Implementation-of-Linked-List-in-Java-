
class NodeDLL
{
	protected int data;
	protected NodeDLL previous;
	protected NodeDLL next;
	
	public NodeDLL(int val)
	{
		data = val;
	}
	public String toString()
	{
		//System.out.println(data);
		return " " + data +" ";
	}
}

class DLList
{
	protected NodeDLL first;
	protected NodeDLL last;
	
	public DLList()
	{
		first = null;
		last = null;
	}
	public boolean isEmpty()
	{
		return first == null;
	}
	public void insertFirst(int value)
	{
		NodeDLL newNodeDLL = new NodeDLL(value);
		if (isEmpty())
			last = newNodeDLL;
		else
		{
			first.previous = newNodeDLL;
		}
		newNodeDLL.next = first;
		first = newNodeDLL;
	}
	public void insertLast(int value)
	{
		NodeDLL newNodeDLL = new NodeDLL(value);
		if(isEmpty())
			first = newNodeDLL;
		else
		{
			last.next = newNodeDLL;
			newNodeDLL.previous = last;
		}
		
		last = newNodeDLL;
	} 
	public NodeDLL deleteFirst()
	{
		NodeDLL temp = first;
		if(first.next == null)
			first = null;
		else
		{
			first.next.previous = null;
		}
		first = first.next;
		return first;
	}
	public NodeDLL deleteLast()
	{
		NodeDLL temp = last;
		if (isEmpty())
			last = null;
		else
		{
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}
	public boolean insertAfter(int key, int value)
	{
		NodeDLL current = first;
		while(current.data!= key)
		{
			current = current.next;
			if (current == null)
				return false;
		}
		NodeDLL newNodeDLL = new NodeDLL(value);
		if(current == last)
		{
			newNodeDLL.next = null;
			last = newNodeDLL;
		}
		else
		{
			newNodeDLL.next = current.next;
			
			current.next.previous = newNodeDLL;
		}
		newNodeDLL.previous = current;
		current.next = newNodeDLL;
		return true;
			
	}
	public NodeDLL deletekey(int key)
	{
		NodeDLL current = first;
		while(current.data != key)
		{
			current = current.next;
		}
		if (first == null)
		{
			return null;
		}
		
		if(current == first)
		{
			first = current.next;
		}
		else
		{
			current.previous.next = current.next;
		}
		
		if(current == last)
		{
			last = current.previous;
		}
		else
		{
			current.next.previous = current.previous;
		}
		
		return current;
	}
	public String toString()
	{
		NodeDLL current = first;
		String str = "Doubly LinkedList: ";
		while(current != null)
		{
			str += current.toString();
			current = current.next;
		}
		System.out.println(" ");
		return str;
	}
}
public class DoublyLinkedList {

	public static void main(String argv[])
	{
		DLList dll = new DLList();
		dll.insertFirst(7);
		dll.insertFirst(9);
		dll.insertFirst(2);
		
		System.out.println(dll);
		
		dll.insertLast(4);
		dll.insertLast(8);
		
		System.out.println(dll);
		
		
		dll.insertAfter(2, 12);
		
		System.out.println(dll);
		
		dll.insertAfter(7, 17);
		
		System.out.println(dll);
		
		
		
		dll.deleteFirst();
		
		System.out.println(dll);
		
		dll.deleteLast();
		
		System.out.println(dll);
		
		
		
		dll.deletekey(7);
		
		System.out.println(dll);
		
		
		
	}
}
