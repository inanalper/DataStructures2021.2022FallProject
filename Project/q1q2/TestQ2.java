package q1q2;

import java.util.ArrayList;

public class TestQ2 {
	public static void main(String[] Args) {
		//We suppose that L1 and L2 are arrays
		Integer[] L1 = {1,3,4,5,7,9,11,12,13,14,15,16,17,19};
		Integer[] L2 = {2,3,4,6,7,8,10,12,13,14,16,18,20};
		//first lets assign these two arrays to our AVL Tree
		for(int i=0;i<L1.length;i++) {
			Node.root.add(L1[i]);
		}
		for(int i=0;i<L2.length;i++) {
			Node.root.add(L2[i]);
		}
		//lets assign our all nodes in the tree to an ArrayList
		ArrayList<Integer> temp = new ArrayList<>();
		Node.root.assignTraversalToArrayList(temp);
		//(OPTIONAL)lets turn our ArrayList into an array to gain some more space in disk(arraylists use more space than the actual datas)
		int[] L3 = new int[temp.size()];
		for(int i=0;i<temp.size();i++) {
			L3[i] = temp.get(i);
		}
		//lets change our pointer to null so garbage collector deletes the arraylist
		temp=null;
		//print the new list
		for(int i=0;i<L3.length;i++) {
			System.out.print(L3[i] + " ");
		}
	}
}
