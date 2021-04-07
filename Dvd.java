public class Dvd extends Item{
	private int length; //in minutes
	public Dvd(String name, String author, String genre, int length) {
		super(name, author, genre, "dvd");
		this.length = length;
	}

	
	@Override
	public void getInfo() {
		//Provides a preview of a dvd
		System.out.println(getName() + "is a " + getGenre() + " movie by " + getAuthor());
		System.out.println("Runtime (in mintutes): " + getLength());
	}
	
	//retrieves runtime of title in minutes
	public int getLength() {
		return length;
	}


	
}