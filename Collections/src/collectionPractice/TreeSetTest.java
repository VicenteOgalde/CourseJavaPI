package collectionPractice;

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
		Items second= new Items(2, "number 2");
		Items third= new Items(3, "number 3");
		
		TreeSet<Items> items= new TreeSet<Items>();
		
		items.add(second);
		items.add(first);
		items.add(third);
		
		for (Items item : items) {
			System.out.println(item.getDescription());
		}

	}

}

class Items implements Comparable<Items> {

	private int id;
	private String description;

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

}
