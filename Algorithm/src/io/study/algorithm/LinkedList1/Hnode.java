package io.study.algorithm.LinkedList1;

public class Hnode {
	
	private String data; //node data
	public Hnode link; //node 포인
	
	public Hnode() {
		this.data = null;
		this.link = null;
		
	}
	
	// Node 생성 
	public Hnode(String data) {
		this.data = data;
		this.link = null;
	}
	
	
	
	public Hnode(String data, Hnode link) {
		this.data = data;
		this.link = link;
		
	} 

	public String getData() {
		return this.data;
	}
}
