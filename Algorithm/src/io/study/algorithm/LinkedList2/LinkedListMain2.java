package io.study.algorithm.LinkedList2;

public class LinkedListMain2 {

	public static void main(String[] args) {

		
		//Node 앞에 Node 추가하기
		LinkedList2 numbers = new LinkedList2();
		numbers.addFirst(10);
		numbers.addFirst(20);
		numbers.addFirst(30);
		numbers.addFirst(40);
		
		//tail 뒤에 노드 추가하기
		numbers.addLast(5);
		
		//인덱스 위치에 노드 add 하기
		numbers.add(2,5);
		
		System.out.println(numbers.toString());
		
		// 첫번째값 삭제  
		
		System.out.println(numbers.removeFirst());
		System.out.println(numbers.remove(2));
		System.out.println(numbers);
		
		System.out.println(numbers.removeLast());
		
		System.out.println(numbers.size());
		
		// node index 위치의 데이터 가져오
		System.out.println(numbers.get(1));
		
		
		//indexof의linkedlist 버전 data를 넣었을때 노드의 위치   
		System.out.println(numbers.indexOf(10));
		
		LinkedList2.ListIterator i = numbers.listIterator();
		System.out.println(i.next());
		System.out.println(i.next());
		System.out.println(i.next());
		System.out.println(i.hasNext());
		System.out.println("_______________________");
		
		LinkedList2 numbers2 = new LinkedList2();
		
		numbers2.addLast(20);
		numbers2.addLast(30);
		numbers2.addLast(40);
		
		LinkedList2.ListIterator j = numbers2.listIterator();
		j.add(5); //
		j.next();

		j.add(5);
		System.out.println(numbers2);
	}

}
