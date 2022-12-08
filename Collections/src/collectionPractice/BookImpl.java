package collectionPractice;

public class BookImpl {

	public static void main(String[] args) {
		
		Book book1=new Book("book1","author1",1);
		Book book2=new Book("book1","author1",1);
		
		if(book1.equals(book2)) {
			System.out.println("same");
			System.out.println(book1.hashCode());
			System.out.println(book2.hashCode());
		}else {
			System.out.println("not the same");
			System.out.println(book1.hashCode());
			System.out.println(book2.hashCode());
		}

	}

}
