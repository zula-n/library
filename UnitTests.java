import java.util.ArrayList;

public class UnitTests {

	public static void main(String args[]) {
		sortByAlphabetTest();
		System.out.println();
		binarySearchTest();
		System.out.println();
		addBooksTest();
		System.out.println();
		checkOutTest();
		System.out.println();

	}

	public static void sortByAlphabetTest() {
		ZulasLibrary library = new ZulasLibrary();
		ArrayList<String> sorted = new ArrayList<String>();
		sorted.add("Harry Potter and the Order of Phoenix");
		sorted.add("Man's Search for Meaning");
		sorted.add("Midnight Sun");
		sorted.add("The Ballad of Songbirds and Snakes");
		sorted.add("The Big Sleep");
		sorted.add("The Help");
		library.addBooks();
		library.selectionSortBooks(library.books);
		for (int i = 0; i < library.books.size(); i++) {
			if (library.books.get(i).getName() != sorted.get(i)) {
				System.out.println("Selection Sort Unsuccessful.");
				return;
			}

		}
		System.out.println("Selection Sort Successful! ");
		System.out.println("Movies By Alphabet: ");
		for (int i = 0; i < sorted.size(); i++) {
			System.out.println(sorted.get(i));
	
		}
		System.out.println("Test 1 Passed.");

		
	}

	public static void binarySearchTest() {
		ZulasLibrary library = new ZulasLibrary();
		library.addDvds();
		if (library.binarySearchDvd(library.dvds, 0, library.dvds.size(), "Onward") == 5) {
			System.out.println("Item Found In Library!");
			System.out.println("Test 2 Passed.");
		} else {
			System.out.println("Item Not Found in Library.");
		}

	}

	public static void checkOutTest() {
		ZulasLibrary checkout = new ZulasLibrary();
		checkout.addDvds();
		checkout.checkOut("The Assistant");

		for (String s : checkout.cart) {
			if (s == "The Assistant") {
				System.out.println("Successfully Added To Cart!");
				System.out.println("Test 4 Passed.");
				return;
			}
		}
		System.out.print("Failed To Add To Cart");

	}

	public static void addBooksTest() {
		ZulasLibrary add = new ZulasLibrary();
		ArrayList<String> shelf = new ArrayList<String>();
		shelf.add("Man's Search for Meaning");
		shelf.add("Midnight Sun");
		shelf.add("The Ballad of Songbirds and Snakes");
		shelf.add("Harry Potter and the Order of Phoenix");
		shelf.add("The Big Sleep");
		shelf.add("The Help");
		add.addBooks();
		add.selectionSortBooks(add.books);
		for (int i = 0; i < add.books.size(); i++) {
			if (add.books.get(i).getName() != shelf.get(i)) {
				System.out.println("Books Successfully Added:");
				for (int j = 0; j < shelf.size(); j++) {
					System.out.println(shelf.get(j));
					}
				System.out.println("Test 3 Passed.");

				return;
			}

		}
		System.out.println("Books Were Not Added");
	}

}


