package io.study.algorithm.LinkedList2;


//
public class LinkedList2 {
	
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
		
		private Object data;
		private Node next;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		
		public String toString() {
			return String.valueOf(this.data);
			
		}
		
	}
	
	public String toString() {
		if(head == null) {
			return "[]";
		}
		Node temp = head;
		String str = "[";
		
		while(temp.next != null) {
			str += temp.data + ", ";
			temp = temp.next;
		}
		str += temp.data;
		
		return str + "]";
		
	}
	
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head; //새로 생성한 노 다음 노드를 Head 노드로 지정함. 
		head = newNode;
		
		size ++;
		if(head.next == null) tail = head;
				
	}
	
	public void addLast(Object input) {
		Node newNode = new Node(input);
		if(size == 0) {
			addFirst(input);
		}else {
			tail.next = newNode;
			tail = newNode;
			size ++;
		}
		
	}
	public void add(int k, Object input) {
		
		if(k == 0 ) {
			addFirst(input);
		} else {
			Node temp1 = node(k-1);
			Node temp2 = temp1.next;
			
			Node newNode = new Node(input);
			
			temp1.next = newNode;
			newNode.next = temp2;
			size ++;
			
			if(newNode.next == null) {
				tail = newNode;
			}
		}
	}
	
	public Object removeFirst() {
		
		Node temp = head;
		head = head.next;
		
		Object returnData = temp.data;
		temp = null;
		size --;
		
		return returnData;
	}
	
	
	//index -1 번째 노드 구하
	private Node node(int index) {
		Node x = head;
		for(int i =0; i < index; i++) {
			x = x.next;
		}
		
		return x;
	}
	
}
