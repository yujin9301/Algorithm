package io.study.algorithm.doubledlinkedlist;


//
public class DoubledLinkedList {
	
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
		
		private Object data;
		
		private Node prev; //이전 노드 link
		private Node next; //다음 노드 link
		
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
	
	//맨앞에 노드를 추가하는 메소드. 
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head; //새로 생성한 노드 다음 노드를 Head 노드로 지정함. 
		
		//head가 존재 할때 이전 노드를 새로 추가 되는 노드로 변경.
		if(head != null) {
			head.prev = newNode;
		}	
		
		//맨 처음 값을 새로운 노드로 변경 
		head = newNode;
		size ++;
		
		if(head.next == null) tail = head;
				
	}
	
	//맨뒤에 노드 추가하는 메소드 . 
	public void addLast(Object input) {
		Node newNode = new Node(input);
		
		//노드가 없을 때,addFirst에 처음 추가하는  로직과 같음. 
		if(size == 0) {
			addFirst(input);
		}else {
			//꼬리가 가리키고 있는 노드 다음 노드를 가리 킴. 
			tail.next = newNode;
			//새로운 노드 이전 노드는 tail 노드를 가리 킴.
			newNode.prev = tail; 
			//tail 노드는 새로 추가한 노드가 됨.
			tail = newNode;
			size ++;
		}
		
	}
	
	//인덱스 값의 위치에 노드를 위치 시키고 현재 노드는 뒤로 뺌. 
	public void add(int k, Object input) {
		
		//인덱스가 0일 경우 맨앞에 추가 하는 거와 같기 때문에 addFirst 호
		if(k == 0 ) {
			addFirst(input);
		} else {
			// 인덱스 노드의 전 노드를 temp1에 지정. 
			Node temp1 = node(k-1);
			
			//temp1의 다음 노드를 temp2로 지정.
			Node temp2 = temp1.next;
			
			//새로운 노드 생성  
			Node newNode = new Node(input);
			
			//새로운 노드를 temp1 노드의 next로 지정 
			temp1.next = newNode;
			//새로운 노드의 next는 이전 노드가 가르키고 있던 노드 지정(원래의 index 노드) 
			newNode.next = temp2;
			
			// 기존 index 노드의 다음이 있으면 기존 노드의 전 노드를 새로운 노드로 변경. 
			if(temp2 != null){
				temp2.prev = newNode;
			}
			
			//새로 추가된 노드는 기존 노드의 전노드로 지정. 
			newNode.prev = temp1;
			size ++;
			
			// 새로운 노드의 next가null이면 새로운 노드가 tail
			if(newNode.next == null) {
				tail = newNode;
			}
		}
	}
	
	//첫번째 노드 삭제하는 메소드 .
	public Object removeFirst() {
		
		Node temp = head;
		head = head.next;
		
		Object returnData = temp.data;
		temp = null;
		if(head != null) {
			head.prev = null;
		}
		size --;
		
		return returnData;
	}
	
	
	//index -1 번째 구하기 더블드링크드리스트는 위치에 따라 앞, 뒤에서 조회하는거에 따라 성능이 달라짐. 
	
	private Node node(int index) {
	
		if(index < size/2) {
			Node x = head;
			for(int i =0; i < index; i++) {
				x = x.next;
			}
			return x;
		} else {
			Node x = tail;
			for(int i = size-1; i > index; i--) {
				x = x.prev;
			}
			return x;
		}
		
	}
	
	// k 인덱스 노드를 삭제하는 메소드 
	public Object remove(int k) {
		
		if(k == 0) {
			return removeFirst();
		}
		//삭제 하려는 노드 전노드를temp로 지
		Node temp = node(k-1);
		
		//우리가 삭제 하려는 노드는 이전노드의 다음 노드   
		Node todoDeleted = temp.next;
		
		//우리가 삭제하려는 노드의 다음 노드. 
		temp.next = temp.next.next;
		
		//위 다음 노드의 전 노드를 이전노드의 전노드로 지정. 
		temp.next.prev = temp;
		
		Object returnData = todoDeleted.data;
		
		
		if(todoDeleted == tail) {
			tail = temp;
		}
		todoDeleted = null;
		
		size --;
		
		return returnData; 
	}
	
	public Object removeLast() {
		return remove(size-1);
	}
	
	public int size() {
		return size;
	}
	
	public Object get(int k) {
		Node temp = node(k);
		
		return temp.data;
	}
	
	public int indexOf(Object data) {
		
		Node temp = head;
		int index = 0;
		while(temp.data != data) {
			
			temp = temp.next;
			index ++;
			if(temp == null) {
				return -1;
			}
		}
		return index;
	}
	
	public ListIterator listIterator() {
		
		
		return new ListIterator();
		
	}
	
	//다음 노드 탐색과 이전노드 탐색이 포함. 
	class ListIterator {
		
		private Node next;
		private Node lastReturned;
		private int nextIndex;
		
		ListIterator(){
			next = head;
			nextIndex = 0;
		}
		public Object next() {
			lastReturned = next;
			next = next.next;
			
			nextIndex++;
			return lastReturned.data;
		}
		
		
		public boolean hasNext() {
			
			
			return nextIndex < size();
		}
		//이전 노드가 존재하는지.
		public boolean hasPrevious() {
			
			return nextIndex > 0; 
		}
		public Object previous() {
			if(next == null) {
				lastReturned = next = tail;
			} else {
				lastReturned = next = next.prev;
			}
			nextIndex--;
			return lastReturned.data;
		}
		
		//next 중 추
		public void add(Object input) {
			Node newNode = new Node(input);
			
			//next를 리턴하지 않은상태. 
			if(lastReturned==null) {
				head = newNode; //head는 새로운 노드 
				newNode.next = next; //새로운 노드는 그 다음 노드를 next로 지정 
			}else {
				lastReturned.next = newNode;
				newNode.prev = lastReturned;
				
				// next 가 null이 아니면 새로운 노드의 다음 노드는 
				if(next != null) {
					newNode.next = next;
					next.prev = newNode;
				} else {
					tail = newNode;
				}
				newNode.next = next;
					
			}
			
			lastReturned = newNode;
			nextIndex ++;
			size ++;
			
		}
		
		public void remove() {
			//if(lastReturned==null)
			if(nextIndex==0) {
				throw new IllegalStateException();
				
			} 
			Node n = lastReturned.next;
			Node p = lastReturned.prev;
			
			//p가 있으면head 값이 아님. 
			if(p==null) {
				head = n;
				head.prev = null;
				lastReturned = null;
			}else {
				p.next = next;
				lastReturned.prev = null;
			}
			if(n == null) {
				tail = p;
				tail.next = null;
			} else {
				
				n.prev = p;
			}	
			if(next == null) {
				lastReturned = tail;
			}else {				
				lastReturned = next.prev;
			}
			
			size --;
			nextIndex --;
		}
	}
	
	
	
}
