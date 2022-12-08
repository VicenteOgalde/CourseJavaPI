package collectionPractice;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {

	public static void main(String[] args) {
		
		LinkedList <String> persons = new LinkedList<>();
		persons.add("ana");
		persons.add("sun");
		persons.add("law");
		persons.add("sid");
		ListIterator<String> it= persons.listIterator();
		
		it.next();
		it.add("tex");
		
		for(String i:persons) {
			System.out.println(i);
		}
		
	}

}
