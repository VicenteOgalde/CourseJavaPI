package collectionPractice;

import java.util.Objects;

public class Book {
	
	private String title;
	private String author;
	private int ISBN;
	public Book(String title, String author, int iSBN) {
		super();
		this.title = title;
		this.author = author;
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	@Override
	public String toString() {
		return "Book [getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor() + ", getISBN()=" + getISBN() + "]";
	}
	/*
	public boolean equals(Object o) {
		if(o instanceof Book) {
			Book bk =(Book)o;
			if(this.ISBN==bk.ISBN) {
				return true;
			}else
				return false;
		}else
			return false;
	}*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ISBN;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		if (ISBN != other.ISBN)
			return false;
		return true;
	}

	

}
