package collectionPractice;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {

	public static void main(String[] args) {
		/*
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
		*/
		
		LinkedList<String> countries= new LinkedList<String>();
		
		countries.add("Spain");
		countries.add("Colombia");
		countries.add("Mexico");
		countries.add("Peru");
		
		LinkedList<String> capitals= new LinkedList<String>();
		
		capitals.add("Madrid");
		capitals.add("Bogota");
		capitals.add("Mexico City");
		capitals.add("Lima");
		
		ListIterator<String> iterCountries= countries.listIterator();
		ListIterator<String> iterCapitals=capitals.listIterator();
		
		while(iterCapitals.hasNext()) {//add between position
			if(iterCountries.hasNext()) {
				iterCountries.next();
			}
			iterCountries.add(iterCapitals.next());
		}
		System.out.println(countries);
		
		iterCapitals=capitals.listIterator();
		
		while(iterCapitals.hasNext()) {//remove pair items position
			iterCapitals.next();
			if(iterCapitals.hasNext()) {
				iterCapitals.next();
				iterCapitals.remove();
			}
			
		}
		System.out.println(capitals);
		
		countries.removeAll(capitals);// remove linkedlist capitals from countries
		
		System.out.println(countries);
	}

}
