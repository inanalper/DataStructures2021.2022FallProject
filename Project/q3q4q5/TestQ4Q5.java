package q3q4q5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestQ4Q5 {
	  public static void main(String[] args) throws IOException {
		  
		  MyLinkedList[] hashmap = new MyLinkedList[997];//create hashmap
		  for(int i=0;i<hashmap.length;i++) {//initialize hashmap
				hashmap[i]=new MyLinkedList();
		  }
		  
		  File sample = new File("C:\\Users\\cehen\\Desktop\\sample.txt"); //TODO change the name of the file
		  Scanner scan = new Scanner(sample);
		  while (scan.hasNextLine()) {
			  String data = scan.next();
			  hashmap[Math.abs((int)(hash(data.toLowerCase())%hashmap.length))].add(data.toLowerCase());//adding each word to hashmap
	      }
		  ArrayList<String> singleList = new ArrayList<>();//lets turn our seperate lists to a single list.
		  for(int i=0;i<hashmap.length;i++) {
			  hashmap[i].toArrayListWithCounts(singleList);
		  }
		  System.out.println("Distinct word size = "+hashmap[0].distinctSize);
		  Collections.sort(singleList);//to print alphabetically
		  System.out.println(singleList.toString());
	  }
		public static long hash(String s) {//simple hash algorithm(this algorithm prevents the different letters with the same characters to have same hash value for ex: "spil" and "lips")
			long hash = 0;
			for(int i = 0; i < s.length();i++) {
				hash = 31 * hash + s.charAt(i);
			}
			return hash;
		}
}
