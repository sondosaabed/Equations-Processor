package model;

public class Node<T> {
	/*
	 * This is the generic node Class 
	 * will use the Equation as the data
	 */
	private T data;
	private Node<T> next;
	
	public Node(T data) {
		setData(data);
		setNext(null);
	}

	/*
	 * GEtters & Setters
	 */
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
}