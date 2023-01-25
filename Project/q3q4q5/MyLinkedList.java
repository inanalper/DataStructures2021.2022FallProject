package q3q4q5;

import java.util.ArrayList;

public class MyLinkedList {
	String data;
	MyLinkedList next;
	int count=1;
	public static int distinctSize=0;/*we are increasing this static variable when 
	some new node added to some MyLinkedList. So we are counting the distinct 
	words(all the MyLinkedList objects)*/
	
	public void add(String s) {
		if(this.data==null) {
			this.data=s;
			distinctSize++;
		}else if(this.data.equals(s)) {
			count++;
		}else if(this.next!=null) {
			this.next.add(s);
		}else if(this.next==null) {
			this.next = new MyLinkedList();
			this.next.data=s;
			distinctSize++;
		}
		
	}
	public void print() {
		if(this.data!=null) {
			System.out.print(data+"="+count+" ");
		}
		
		if(this.next!=null) {
			this.next.print();
		}
	}
	public void toArrayList(ArrayList<String> list) {//(For Q3)adding all data that are not null in each myLinkedList objects to a list
		if(this.data!=null) {
			list.add(this.data);
		}
		
		if(this.next!=null) {
			this.next.toArrayList(list);
		}
	}
	public void toArrayListWithCounts(ArrayList<String> list) {//(FOR Q5)
		if(this.data!=null) {
			list.add(this.data+"="+count);
		}
		
		if(this.next!=null) {
			this.next.toArrayListWithCounts(list);
		}
	}
}
