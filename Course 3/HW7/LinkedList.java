import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public Node<T> getHead() {
		return this.head;
	}
	
	public Node<T> getTail() {
		return this.tail;
	}

	@Override
	public void addAtIndex(T data, int index) {
		
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Your index is out of the list bounds");
		}
		if (data == null) {
			throw new IllegalArgumentException("You cannot add null data to the list");
		}
		
		Node<T> newNode = null;
		
		if (index == 0) {
			newNode = new Node<T>(data, head);
			head = newNode;
			if (size == 0) {
				tail = newNode;
			}
		} else {
		
			Node<T> currNode = head;
			int indexcopy = index;
			
			while (indexcopy > 1 && currNode != null) {
				indexcopy--;
				currNode = currNode.getNext();
			}
			
			newNode = new Node<T>(data, currNode.getNext());
			currNode.setNext(newNode);
			
			if (index == size) {
				tail = newNode;
			}
		}
		size++;
		
	}

	@Override
	public T getAtIndex(int index) {
		
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("Your index is out of the list bounds");
		}
		
		if (index == 0) {
			return head.getData();
		}
		
		Node<T> currNode = head;
		
		while (index > 0 && currNode != null) {
			index--;
			currNode = currNode.getNext();
		}
		
		if (currNode == null) {
			throw new NoSuchElementException();
		} else {
			return currNode.getData();
		}
	}

	@Override
	public T removeAtIndex(int index) {
		
		if (index < 0 || index > size - 1) {
			throw new IllegalArgumentException("Your index is out of bounds");
		}
		T tempData = null;
		if (index == 0) {
			tempData = head.getData();
			head = head.getNext();
			if (size == 1) {
				tail = head;
			}
		} else {
			
			Node<T> currNode = head;
			int indexcopy = index;
			while (indexcopy > 1 && currNode != null) {
				indexcopy--;
				currNode = currNode.getNext();
			}
			
			Node<T> tempNode = currNode.getNext();
			tempData = tempNode.getData();
			currNode.setNext(tempNode.getNext());
			tempNode = null;
			
			if (index == size - 1) {
				tail = currNode;
			}
		}
		size--;
		return tempData;
	}

	@Override
	public T remove(T data) {
		if (data == null) {
			throw new IllegalArgumentException("You cannot remove null data from the list");
		}
		T tempData = null;
		if (head == null) { 
			throw new NoSuchElementException("The data is not present in the list.");
		} else if (head.getData() == data) {
			tempData = head.getData();
			head = head.getNext();
			if (size == 1) {
				tail = null;
			}
		}else {
			Node<T> currNode = head;
			Node<T> prevNode = null;
			while (currNode.getData() != data && currNode.getNext() != null) {
				prevNode = currNode;
				currNode = currNode.getNext();
			}
			
			if (currNode.getData() == data) {
				prevNode.setNext(currNode.getNext());
				tempData = currNode.getData();
			} else {
				throw new NoSuchElementException("The data is not present in the list.");
			}
		}
		size--;
		return tempData;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	@Override
	public int size() {
		return this.size;
	}
	
	
}