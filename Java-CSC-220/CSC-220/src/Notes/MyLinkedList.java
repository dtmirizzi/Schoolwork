package Notes;
//@author dtmirizzi

import java.util.Iterator;
import java.util.Objects;

public class MyLinkedList<E> implements Ilist<E>, Iterable<E>{ // you have to input the type of the elements of the list <Integer>etc.

    //	list whose elements are of type E
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //	add a new element to the end of the list
    public void add(E newElement) {
        //	if the list is empty
        if (this.head == null) {
            ListNode<E> node = new ListNode<E>(newElement, null);
            this.head = node;
            this.tail = node;
        } else {
            ListNode<E> node = new ListNode<E>(newElement, null);
            tail.setNext(node);
            this.tail = node;
        }

        size++;
    }

    public void addFront(E newElement) {
        //	if the list is empty
        if (this.head == null) {
            ListNode<E> node = new ListNode<E>(newElement, null);
            this.head = node;
        } else {
            ListNode<E> node = new ListNode<E>(newElement, null);
            node.setNext(this.head);
            this.head = node;
        }

        size++;
    }

    //	get's the i-th element of the list type E ie the input.
    public E get(int i) { 
        if (i < 0) {
            throw new IndexOutOfBoundsException(i + "");
        }

        ListNode<E> current = this.head;
        int n = 0;
        //	hops i times
        while (n != i) {
            if (current == null) {
                throw new IndexOutOfBoundsException(i + "");
            }

            current = current.getNext();
            n++;
        }

        return current.getValue();
    }

    public void delete(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(i + "");
        }
        if (i == 0) {
            this.head = this.head.getNext();
        } else {

            ListNode<E> current = this.head;
            int n = 0;
            //	hops i times
            while (n != i - 1) {
                if (current == null) {
                    throw new IndexOutOfBoundsException(i + "");
                }

                current = current.getNext();

                n++;
            }
            ListNode<E> next = current.getNext();
            current.setNext(next.getNext());
            size--;
        }
    }

    public boolean contains(E content) {
        for (int i = 0; i < size; i++) {
            if (this.get(i) == content) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return Size
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.head);
        hash = 97 * hash + Objects.hashCode(this.tail);
        hash = 97 * hash + this.size;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MyLinkedList<?> other = (MyLinkedList<?>) obj;
        if (this.size != other.size) {
            return false;
        }
        ListNode current = this.head;
        ListNode currentObj = other.head;
        for (int i = 1; i < size; i++) {

            if (!(current.getValue().equals(currentObj.getValue()))) {
                return false;
            }
            current= current.getNext();
            currentObj= currentObj.getNext();
            
        }
        return true;
    }

    @Override
    public String toString() {
        //return "MyLinkedList [head=" + head + ", tail=" + tail + ", size=" + size + "]";
        String S = new String();
        S = "MyLinkedList [" + this.head.getValue();
        ListNode current= this.head.getNext();
        for (int i = 1; i < size; i++) {
            S = S + ", " + current.getValue();
            current= current.getNext();
        }
        S = S + "]";
        return S;
    }
    public ListNode<E> getHead(){
	return this.head;
    }
     public Iterator<E> iterator() {
	return new MyLinkedListIt<E>(this.head);
    }

}

////	finds the last node in the list
//
//ListNode current = this.head;
////	while current.next is not null, set current = current.next
//while (current.getNext() != null)
//{
//	current = current.getNext();
//}
//	current.next = node

