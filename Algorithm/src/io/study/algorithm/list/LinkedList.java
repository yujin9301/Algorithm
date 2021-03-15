package io.study.algorithm.list;

import io.study.algorithm.list.Hnode;

public class LinkedList {

		private Hnode head;
		
		//head 초기
		public LinkedList() {
			head = null;
		}
		
		//노드 추가 
		public void add(String data) {
			
			Hnode node = new Hnode(data);
			
			//첫번째 노드 생성 
			if(head == null) {
				
				head = node;

 			}else { //다음 link node 추
				
 				// 참조 노드들을 찾기 위해 temp에 저
 				Hnode tempNode = head;
 				
 				//head안에 link에서 다음 노드 조회 후 다시 temp에 담
 				while(tempNode.link != null) {
 					tempNode = tempNode.link;
 				}
 				// 더이상link가 없을 때 추가 되는 노드를 넣음.
 				tempNode.link = node;    
 				
			}
			
			
		}
		
		// 노드 탐색 - 처음부터 하나하나 탐색 해야함.
		public Hnode searchNode(String data) {
			
			Hnode currentNode = this.head;
			
			while(currentNode != null) {
				if(data.equals(currentNode.getData())) {
					return currentNode;
				}else {
					currentNode = currentNode.link;
				}
			}
			
			return currentNode;
		}

		//중간 노드 삭제
		public void deleteNode(String data) {
			
			
		}
		//마지막 노드 삭제
		public void deleteNode() {
			
			Hnode currentNode = this.head;
			if(currentNode != null) {
				while(currentNode.link != null) {
					currentNode = currentNode.link;
				}
				currentNode = null;
			}
		}
	}
