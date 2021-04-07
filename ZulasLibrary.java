import java.util.ArrayList;
import java.util.Scanner;

public class ZulasLibrary implements Library {
	public ArrayList<String> cart = new ArrayList<String>();
	public ArrayList<Book> books = new ArrayList<Book>();
	public ArrayList<Dvd> dvds = new ArrayList<Dvd>();
	private Scanner scnr;
	
	//add books to arraylist
	public void addBooks() {
		books.add(new Book("Man's Search for Meaning", "Viktor Frankl", "Psychology", 200));
		books.add(new Book("Midnight Sun", "Stephanie Meyer", "Romance", 672));
		books.add(new Book("The Ballad of Songbirds and Snakes", "Suzanne Collins", "Science Fiction", 528));
		books.add(new Book("Harry Potter and the Order of Phoenix", "J.K. Rowling", "Fantasy Fiction", 766));
		books.add(new Book("The Big Sleep", "Raymond Chandler", "Mystery", 277));
		books.add(new Book("The Help", "Kathryn Stockett", "Historical Fiction", 524));
	}
	
	//add dvds to arraylist
	public void addDvds() {
		dvds.add(new Dvd("Bad Boys for Life", "Adil & Bilall", "Action & Adventure", 124));
		dvds.add(new Dvd("Jumanji: The Next Level", "Jake Kasdan", "Action & Aventure", 123));
		dvds.add(new Dvd("The Assistant", "Kitty Green", "Drama", 87));
		dvds.add(new Dvd("The Photograph", "Stella Meghie", "Drama", 106));
		dvds.add(new Dvd("UnderWater", "William Eubank", "Thriller", 95));
		dvds.add(new Dvd("Onward", "Dan Scanlon", "Kids & Family", 102));
	}

	@Override
	/**
	 * @param String 
	 * Calls methods searchDvd(name) and searchBook(name) accordingly
	 * If name exists, prompts customer to confirm checking out the book
	 * or dvd, if yes, add to cart and remove from correct ArrayList
	 */
	public void checkOut(String name) {
		//checks if exists
		boolean isInDvds = !(searchDvd(name) == null);
		boolean isInBooks = !(searchBook(name) == null);
		//if dvd exists in library, prompt user to checkout
		if (isInDvds) {
			System.out.println("Would you like to checkout " + name + "?");
			System.out.println("Press 1 to proceed, 2 to cancel");
			scnr = new Scanner(System.in);
			if (scnr.nextInt() == 1) {
				Dvd dvd = searchDvd(name);
				cart.add(dvd.getName());
				dvds.remove(dvd);
				System.out.println(cart);
			}
		} else if (isInBooks) {
			//if book exists in library, prompt user to checkout
			System.out.println("Would you like to checkout " + name + "?");
			System.out.println("Press 1 to proceed, 2 to cancel");
			scnr = new Scanner(System.in);
			if (scnr.nextInt() == 1) {
				Book book = searchBook(name);
				cart.add(book.getName());
				books.remove(book);
				System.out.print(cart);
			}
		} else {
			//if not present in either dvds or books, print not available
			System.out.print(name + " not available.");
		}

	}


	@Override
	//searches for book name in list of books
	public Book searchBook(String name) {
		for (Book book : books) {
			if (name == book.getName()) {
				return book;
			}
		}
		return null;
	}

	@Override
	//searches for dvd name in list of dvds
	public Dvd searchDvd(String name) {
		for (Dvd dvd : dvds) {
			if (name == dvd.getName()) {
				return dvd;
			}
		}
		return null;
	}

	@Override
	public int binarySearchBook(ArrayList<Book> book, int right, int left, String name) {
		if (right >= left) {
			int mid = left + (right - left) / 2;

			// If the element is present at the
			// middle, return it
			if (book.get(mid).equals(name)) {
				return mid;
			}

			// If element is smaller than mid, then
			// it may only be in the left side array
			if (book.get(mid).toString().compareTo(name) >= 1) {
				return binarySearchBook(book, left, mid - 1, name);
			}

			// If not, element can only be present
			// in right side array
			else {
				return binarySearchBook(book, mid + 1, right, name);
			}
		}

		//element is not present
		return -1;

	}
	
	public int binarySearchDvd(ArrayList<Dvd> dvd, int left, int right, String name) {
		if (right >= left) {
			int mid = left + (right - left) / 2;

			// If the element is present at the
			// middle, return it
			if (dvd.get(mid).getName().equals(name)) {
				return mid;
			}

			// If element is smaller than mid, then
			// it may be present in the left side array
			if (dvd.get(mid).getName().compareTo(name) < 0) {
				return binarySearchDvd(dvd, left, mid - 1, name);
			}

			// If not, element can only be present
			// in right side array
			else {
				return binarySearchDvd(dvd, mid + 1, right, name);
			}
		}

		// We reach here when element is not present
		// in array
		return -1;

	}

	@Override
	public boolean selectionSortBooks(ArrayList<Book> item) {
		int smallIndex; // smallest index
		Book temp; // Temporary variable for swap
		

		for (int i = 0; i < item.size(); ++i) {
			smallIndex = i;

			// Find index of smallest remaining element
			for (int j = i + 1; j < item.size(); ++j) {
				if(item.get(j).getName().compareTo(item.get(smallIndex).getName()) < 0) {
					smallIndex = j;
				}
			}

			// Swap 
			temp = item.get(i);
			item.set(i, item.get(smallIndex));
			item.set(smallIndex, temp);

		}
		return true;
	}
	
	public boolean selectionSortDvds(ArrayList<Dvd> item) {
		int smallIndex; // smallest index
		Dvd temp; // Temporary variable for swap

		for (int i = 1; i < item.size(); ++i) {

			// Find index of smallest remaining element
			smallIndex = i - 1;
			for (int j = i + 1; j < item.size(); ++j) {

				if (item.get(i).getName().compareTo(item.get(smallIndex).getName()) <= -1) {
					smallIndex = j;
				}
			}

			// Swap 
			temp = item.get(i);
			item.set(i, item.get(smallIndex));
			item.set(smallIndex, temp);

		}
		return true;
	}


}
