package q1q2;

import java.util.ArrayList;
public class Node {
	
	public Node rightChild;
	public Integer data;
	public Node leftChild;
	public Node parent;
	public static Node root = new Node(); //creates a static variable(only once) root, we will provide access to the tree with that variable
	public int height;
	public static boolean alreadyExists=false;//to stop taking inputs in Q1 Test class
	
	public Node() {}

	public void add(int i) {
		if(data == null) {
			data = i;
			updateHeight(this);
		}else if(i == data) {
			alreadyExists=true;//to stop taking inputs in Q1 Test class
			return;
		}else if(i< data) {
			if(leftChild == null) { //if leftChild is null, we found the place to add
				leftChild = new Node();
				leftChild.data=i;
				leftChild.parent=this;
			}else {
				leftChild.add(i); //else, go to leftChild recursively
			}

		}else if(i> data) {
			if(rightChild == null) {//if rightChild is null, we found the place to add
				rightChild = new Node();
				rightChild.data=i;
				rightChild.parent=this;
			}else {
				rightChild.add(i);//else, go to rightChild recursively
			}
			
		}
		updateHeight(this);//update height backwards(because function is recursive) after adding some node
		if(balanceFactor(this)<-1 || balanceFactor(this)>1) {//checks if we need to balance
				if(this.parent==null) {//runs if "this" is the root(because root cant have a parent)
					root=balance(this);//changes the root(balance(Node node) returns the new sub root)
				}else if(this.data>this.parent.data) {//if "this" is not the root, then parent of the "this" now points the new sub root after balancing
					this.parent.rightChild=balance(this);
				}else {
					this.parent.leftChild=balance(this);
				}	
		}
		
	}
	
	private int height(Node node) {
	    return node != null ? node.height : -1; //return the height if there is, else return -1
	}
	public void updateHeight(Node node) {
	    node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;//set the height 1 more to its highest children
	}
	private int balanceFactor(Node node) {
	    return height(node.rightChild) - height(node.leftChild);//returns the height difference of its children
	  }
	private Node rotateRight(Node node) { //right rotation
		  Node leftChild = node.leftChild;
		  if(leftChild.rightChild!=null) {//to avoid nullPointerException
			  leftChild.rightChild.parent=node;//before adoption, child points its new parent
		  }
		  //some adoption process
		  node.leftChild = leftChild.rightChild;
		  leftChild.rightChild = node;
		  
		  leftChild.parent=node.parent;
		  node.parent=leftChild;
		  
		  updateHeight(node);
		  updateHeight(leftChild);

		  return leftChild;//return the leftChild because now it became the root of the subtree(it went higher)
		}
	private Node rotateLeft(Node node) {//left rotation
		  Node rightChild = node.rightChild;
		  
		  if(rightChild.leftChild!=null) {//to avoid nullPointerException
			  rightChild.leftChild.parent=node;//before adoption, child points its new parent
		  }
		  //some adoption process
		  node.rightChild = rightChild.leftChild;
		  rightChild.leftChild = node;
		  
		  rightChild.parent=node.parent;
		  node.parent=rightChild;
		  
		  updateHeight(node);
		  updateHeight(rightChild);

		  return rightChild;//return the rightChild because now it became the root of the subtree(it went higher)
		}

	private Node balance(Node node) {
		  if (balanceFactor(node) < -1) {//checks if node is left-heavy
		    if (balanceFactor(node.leftChild) <= 0) {//checks if the leftChild is left-heavy, so just righ rotation is enough
		      node = rotateRight(node);
		    } else { //runs if the node is left-heavy and the leftChild is right-heavy, so double rotation needed
		      // double rotation
		      node.leftChild = rotateLeft(node.leftChild);
		      node = rotateRight(node);
		    }
		  }
		  if (balanceFactor(node) > 1) {//checks if node is right-heavy
		    if (balanceFactor(node.rightChild) >= 0) {//checks if the rightChild is right-heavy, so just righ rotation is enough
		      node = rotateLeft(node);
		    } else {//runs if the node is right-heavy and the rightChild is left-heavy, so double rotation needed
		      // double rotation
		      node.rightChild = rotateRight(node.rightChild);
		      node = rotateLeft(node);
		    }
		  }
		  return node;//return the new sub root
		}
	public void traverseInOrderAndPrint() {//print in order traversal
		if(leftChild==null) {
		} else {
			leftChild.traverseInOrderAndPrint();
		}
		System.out.print(data + " ");
		if(rightChild==null) {
		} else {
			rightChild.traverseInOrderAndPrint();
		}
	}
	public void assignTraversalToArrayList(ArrayList<Integer> list) {//for q2
		if(leftChild==null) {
		} else {
			leftChild.assignTraversalToArrayList(list);
		}
		list.add(data);

		if(rightChild==null) {
		} else {
			rightChild.assignTraversalToArrayList(list);
		}
	}
}