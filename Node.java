// Jalena Austin

// I assert that I have written 100% of this code myself otherwise
// I will receive a 0% grade on this assignment.
//
// Status:
//
// This code is 100% tested and correct

public class Node
{
	private Object data;
	private Node next;
	
	public Node(Object data)
	{
		this.data=data;
		next = null;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public Object getData()
	{
		return data;
	}
	
	public void setData(Object data)
	{
		this.data = data;
	}
}