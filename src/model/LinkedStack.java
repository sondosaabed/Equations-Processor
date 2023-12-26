package model;

import java.util.EmptyStackException;

public class LinkedStack<T>{
	/*
	 * This is a simple implementation of a generic type stack
	 */
	private Node<T> top;
	
	/*
	 * A method to push into stack
	 */
	public void push(T item) {
		Node<T> newNode = new Node<>(item);
		newNode.setNext(top);
		setTop(newNode);
	}
	
	/*
	 * A method to pop out from stack
	 */
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T popped = top.getData();
		top = top.getNext();
		return popped;
	}
	
	/*
	 * Check if the top is null return true
	 */
	public boolean isEmpty() {
		return getTop() == null;
	}
	
	/*
	 * This method is used to print the stack to the 
	 * Section extFeilds
	 */
	public String printSection() {
		StringBuilder section = new StringBuilder();
		Node<T> curr = getTop();
		while(curr !=null) {
			section.append(curr.getData().toString() +"\n ");
			curr = curr.getNext();
		}
		return section.toString();
	}
	
	/*
	 * Getters & Setters
	 */
	public Node<T> getTop() {
		return top;
	}

	public void setTop(Node<T> top) {
		this.top = top;
	}

	public char peek() {
		return 0;
	}
}