package Notes;
//@author dtmirizzi

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements Ilist<E>, Iterable<E> {

    //	E is the type of the elements of the list

    private static final int DEFAULT_SIZE = 1;

    private E[] elements;
    private int size;

    //	construct an array list with an initial size for the elements arrayn
    public MyArrayList(int initialSize) {
	elements = (E[]) new Object[initialSize]; //(E[]) casts the object to generic type E.
	size = 0;
    }

    //	construct an array list with a default initial size for the elements array
    public MyArrayList() {
	this(DEFAULT_SIZE);
    }

    //	if we run have run out of room in the array, make it bigger
    public void resizeIfNeedBe() {
	if (size == elements.length) {
	    //	make a bigger array
	    E[] newElements = (E[]) new Object[elements.length * 2];
			//System.out.println("Resizing to size " + newElements.length);
	    //	copy the elements of the old array to the bigger array
	    for (int i = 0; i < elements.length; i++) {
		newElements[i] = elements[i];
	    }
	    //	make the old array point at the bigger array
	    elements = newElements;
	}
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 97 * hash + Arrays.deepHashCode(this.elements);
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
	final MyArrayList<?> other = (MyArrayList<?>) obj;
	if (this.size != other.size) {
	    return false;
	}
	for (int i = 0; i < this.size; i++) {
	    if (other.elements[i] != elements[i]) {
		return false;
	    }
	}
	return true;
    }

    public void add(E num) {
	resizeIfNeedBe();
	//	add the new number to the elements
	elements[size] = num;
	size++;
    }

    public void addFront(E num) {
	resizeIfNeedBe();
	for (int i = size; i > 0; i--) {
	    elements[i] = elements[i - 1];
	}
	elements[0] = num;
	size++;
    }

    public void delete(int i) {
	if (i >= size || i < 0) {
	    throw new IndexOutOfBoundsException(i + "");
	}
	for (int j = i; j < size; j++) {
	    elements[j] = elements[j + 1];
	}
	size--;

    }

    public E get(int i) {
	if (i >= size || i < 0) {
	    throw new IndexOutOfBoundsException(i + "");
	}

	return elements[i];
    }

    public boolean contains(E element) {
	boolean ToF = false;
	for (int i = 0; i < size; i++) {
	    if (elements[i] == element) {
		ToF = true;
	    }
	}

	return ToF;
    }

    public int size() {
	return size;
    }

    @Override
    public String toString() {
	String result = "[";

	for (int i = 0; i < size - 1; i++) {
	    result = result + elements[i] + ", ";
	}
	result = result + elements[size - 1];
	result = result + "]";

	return result;
    }

    public Iterator<E> iterator() {
	return new MyArrayListIt<E>(this);
    }

}
