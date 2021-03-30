package io.study.algorithm.LinkedList2;

public class LinkedListMain2 {

	public static void main(String[] args) {

		
		//Node 앞에 Node 추가하기
		LinkedList2 numbers = new LinkedList2();
		numbers.addFirst(10);
		numbers.addFirst(20);
		numbers.addFirst(30);
		
		
		//tail 뒤에 노드 추가하기
		numbers.addLast(5);
		
		//인덱스 위치에 노드 add 하기
		numbers.add(2,5);
		
		System.out.println(numbers.toString());
		
		// 첫번째값 삭
		System.out.println(numbers);
		
		System.out.println(numbers.removeFirst());
		
		
		//특정한 위치에 있는Node 삭
	}

}
