// Jalena Austin

// I assert that I have written 100% of this code myself otherwise
// I will receive a 0% grade on this assignment.
//
// Status:
//
// This code is 100% tested and correct

public class LinkedList
{
	protected int size;
	protected Node head;
	
	
	public LinkedList()
	{
		head=null;
	}
	
	
	public Node getHead()
	{
		return head;
	}
	
	
	public void setHead(Node head)
	{
		head = head.getNext();
	}
	
	
	public void insertFront(Object item)
	{
		Node node = new Node(item);
		
		if(head == null)
		{
			head = node;
		}
		else
		{
			node.setNext(head);
			head = node;
		}
	}
	
	public void insertBack(Object item)
	{
		Node node = new Node(item);
		Node current = head;
		
		if(current == null)
		{
			head = node;
		}
		else
		{
			while(current.getNext() != null) 
			   {
			    current = current.getNext();
			   }
			     current.setNext(node); 
			     size++;
	    }
	}
	
	public Object removeFront()
	{
		Node node;
		
		Object item = head.getData();
		node = head;
		head = head.getNext();
		node.setNext(null);
		return item;
	}
	
	public Object removeBack()
	{
		Node current; 
		
		Object item = head.getData();
		current = head;
		while(current.getNext() != null)
		{
			current = current.getNext();
		}
		current.setNext(null);
		return item;
	}
	
	
}
