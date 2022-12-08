package collectionPractice;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {

		/*
		TreeSet<String> persons = new TreeSet<String>();

		persons.add("sun");
		persons.add("moon");
		persons.add("ted");

		for (String p : persons) {
			System.out.println(p);
		}
		*/
		Items first= new Items(1, "number 1");
		Items second= new Items(2, "znumber 2");
		Items third= new Items(3, "anumber 3");
		
		TreeSet<Items> items= new TreeSet<Items>();//using comparable for sort using compareTo method
		
		items.add(second);
		items.add(first);
		items.add(third);
		
		for (Items item : items) {
			System.out.println(item.getDescription());
		}
		
		Items comparator = new Items();
		
		TreeSet<Items> sortItems= new TreeSet<Items>(comparator);//use interfaz comparator for sort with string
		
		sortItems.addAll(items);
		
		for (Items item : sortItems) {
			System.out.println(item.getDescription());
		}

	}

}

class Items implements Comparable<Items>,Comparator<Items> {

	private int id;
	private String description;
	

	public Items() {
		
	}

	public Items(int id, String description) {
		this.id = id;
		this.description = description;
	}

	@Override
	public int compareTo(Items o) {

		return this.id-o.id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compare(Items o1, Items o2) {
		
		String descriptionA=o1.getDescription();
		String descriptionB=o2.getDescription();
		
		return descriptionA.compareTo(descriptionB);
	}

}
