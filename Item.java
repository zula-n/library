import java.util.Hashtable;

public abstract class Item {
	public Hashtable<String, String> properties = new Hashtable<String, String>();
	private boolean checkedOut;
	
	//Constructor
	//filling Hashtable 
	public Item(String name, String author, String genre, String type) {
		properties.put("name", name);
		properties.put("author", author);
		properties.put("genre", genre);
		properties.put("type", type);
		checkedOut = false;
	}
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isCheckedOut() {
		return checkedOut;
	}

	//Checking out a title
	public void checkOut() {
		if (isCheckedOut()) {
			System.out.print("Item already checked out.");
		} else {
			checkedOut = true;
			System.out.print("Checkout successful!");
		}
	}

	//getters and setters
	public String getName() {
		return properties.get("name");
	}

	public String getAuthor() {
		return properties.get("author");
	}

	public String getGenre() {
		return properties.get("genre");
	}

	public String getItemType() {
		return properties.get("type");
	}
	
	public abstract void getInfo();

}






