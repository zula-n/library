import java.util.ArrayList;

public interface Library {

public abstract void checkOut(String name);
public abstract Book searchBook(String name);
public abstract Dvd searchDvd(String name);
public abstract int binarySearchBook(ArrayList<Book> book, int right, int left, String name);
public abstract int binarySearchDvd(ArrayList<Dvd> dvd, int right, int left, String name);
public abstract boolean selectionSortBooks(ArrayList<Book> item);
public abstract boolean selectionSortDvds(ArrayList<Dvd> item);
}