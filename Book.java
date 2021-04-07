public class Book extends Item{
	private int pages;
	public Book(String name, String author, String genre, int pages) {
		super(name, author, genre, "book");
		this.pages = pages;
	}

	@Override
	//Provides a preview of a book 
	public void getInfo() {
		System.out.println(getName() + "is a " + getGenre() + " book by " + getAuthor());
		System.out.println("Number of pages: " + getPages());
	}
	
	//retrieves number of pages
	public int getPages() {
		return pages;
	}
}