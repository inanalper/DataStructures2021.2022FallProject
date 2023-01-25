package q1q2;

import java.util.Scanner;

public class TestQ1 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		while(!Node.root.alreadyExists) {//inputs stops if add() method in Node class...
			//...finds the same data in a node and changes the alreadyExists variable to true.
			System.out.print("Sayý giriniz:");
			int x=scan.nextInt();
			Node.root.add(x);
		}
		System.out.println("Ayný sayýyý girdiniz!");
		System.out.println("Sayýlar: ");
		Node.root.traverseInOrderAndPrint();
	}
}
