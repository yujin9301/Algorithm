package io.study.algorithm.LinkedList1;

public class LinkedListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedList = new LinkedList();    // 연결 리스트 생성
        
        for(int i =0; i<10; i++) {
        	linkedList.add("node data index["+i+"]");
        }
        System.out.println("----------------입력 결과 보기 --------------------------");
        linkedList.printNodeList();
        
        String str = "node data index[4]";        
        System.out.println("----------------조회 결과 보기 --------------------------");
       
        //특정 노드 검색 
        System.out.println("조회결과 : ["+linkedList.searchNode(str).getData()+"]");
        
        
        System.out.println("----------------삭제 결과 보기 --------------------------");
        //특정 노드 삭제 
        linkedList.deleteNode(str);
        linkedList.printNodeList();
        


	}

}
