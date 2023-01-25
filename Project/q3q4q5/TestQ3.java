package q3q4q5;
import java.util.ArrayList;
import java.util.Collections;
public class TestQ3 {
	public static void main(String[] args) {
		String[] array = {"emre","thereIs10MoreFromMe","alper","Alper","seckin","kubra","zeynep","repla","erem",
				"mere","didem","medid","dedim","thereIs10MoreFromMe","seckin","thereIs10MoreFromMe",
				"zeynep","didem","thereIs10MoreFromMe","seckin","alper","thereIs10MoreFromMe","kubra",
				"alper","emre","thereIs10MoreFromMe","didem","zeynep","thereIs10MoreFromMe","kubra","mere",
				"arbuk","penyez","thereIs10MoreFromMe","thereIs10MoreFromMe","emre","thereIs10MoreFromMe","erem",
				"thereIs10MoreFromMe"};
		//initialize our hash map
		MyLinkedList[] hashmap = new MyLinkedList[997];//we chose 997 because its prime, its a bit larger array for this example array but works more efficiently when the number of strings increase
		for(int i=0;i<hashmap.length;i++) {
			hashmap[i]=new MyLinkedList();
		}
		for(int i=0; i< array.length;i++) {
			hashmap[Math.abs((int)(hash(array[i].toLowerCase())%hashmap.length))].add(array[i].toLowerCase());/*we used Math.abs because as the string got bigger, the long object would do wrong calculations.
			the computer calculating the number over the byte system could find (as the significant bit value will change) negative results, the program would give an error since there would be no negative array index.*/
		}
		ArrayList<String> singleList = new ArrayList<>();//lets turn our seperate lists to a single list.
		for(int i=0;i<hashmap.length;i++) {
			hashmap[i].toArrayList(singleList);
		}
		Collections.sort(singleList);
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
