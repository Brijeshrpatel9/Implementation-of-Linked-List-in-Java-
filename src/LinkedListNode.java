import org.w3c.dom.Node;

// Implementation of LinkedList using Node

public class LinkedListNode {

	public static void main(String argv[]){
		LinkedList l1 = new LinkedList();
		
		l1.add("1");
		l1.add("2");
		l1.add("3");
		l1.add("4");
		l1.add("A", 2);
		
		System.out.println("Linked List: " + l1);
		System.out.println("Size of the Linked List: " + l1.size());
		System.out.println("Remove the element at position 1 (Linked List starts from 0 position): " + l1.remove(1));
		System.out.println("New List after deletion: " + l1);
		System.out.println("Get Element at third position: "+ l1.get(3));
		
		
	}
}
class LinkedList{
	
	private Node head;
	private int count;
	
	public LinkedList(){
		
		head = new Node(null);
		count = 0;
	}
	
	public void add(Object data){
		Node temp = new Node(data);
		Node current = head;
		while (current.getNext() != null){
			current = current.getNext();
			
		}
		current.setNext(temp);
		count++;
				
	}
	public void add(Object data, int index){
		Node temp = new Node(data);
		Node current = head;
		for(int i = 0; i<index && current.getNext() != null; i++){
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		
	}
	public Object get(int index){
		
		if(index <= 0){
			return null;
		}
		
		Node current = head.getNext();
		for(int i = 0; i < index; i++){
			
			if(current.getNext() == null){
				return null;
			}
			current = current.getNext();
			
		}
		return current.getData();
		
	}
	public boolean remove(int index){
		
		if(index <1 || index > size()){
			return false;
		}
		Node current = head;
		for(int i = 0; i < index; i++){
			if(current.getNext() == null){
				return false;
			}
			
			current = current.getNext();
			
		}
		current.setNext(current.getNext().getNext());
		count--;
		return true;
		
	}
	public int size(){
		return count;
	}
	
	public String toString()
	{
		Node current = head.getNext();
		String output = "";
		while(current != null)
		{
			output += current.getData().toString() + " ";
			current = current.getNext();
		}
		return output;
	}
	private class Node
	{
		Node next;
		Object data;
		
		public Node(Object _data)
		{
			data = _data;
		}
		public Node(Object _data, Node _next)
		{
			data = _data;
			next = _next;
		}
		public Object getData()
		{
			return data;
		}
		public void setData(Object _data)
		{
			data = _data;
		}
		public Node getNext()
		{
			return next;
		}
		public void setNext(Node _next)
		{
			next = _next;
		}
	
	}
	
}
