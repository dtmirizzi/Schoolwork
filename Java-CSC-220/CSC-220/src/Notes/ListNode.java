package Notes;
//@author dtmirizzi
//	stores list nodes of type
public class ListNode<E>
{
	private E value;
	private ListNode<E> next;
	
	public ListNode(E value, ListNode<E> next)
	{
		this.value = value;
		this.next = next;
	}
	
	public E getValue()
	{
		return value;
	}
	
	public ListNode<E> getNext()
	{
		return this.next;
	}

	public void setNext(ListNode<E> next)
	{
		this.next = next;
	}
}