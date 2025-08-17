import java.util.ArrayList;

abstract class LibraryItems {

    protected int itemId;
    protected String title;
    protected Double price;
    protected boolean isBorrowed;

    public LibraryItems(int itemId, String title, Double price) {
        this.itemId = itemId;
        this.title = title;
        this.price = price;
        this.isBorrowed = false;
    }

    abstract String details();

    public void borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    public void returnItem() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }

    public String availability() {
        return isBorrowed ? "Borrowed" : "Available";
    }
}

class Book extends LibraryItems {

    public Book(int itemId, String title, Double price) {
        super(itemId, title, price);
    }

    @Override
    String details() {
        return "Book ID: " + itemId + ", Title: " + title + ", Price: " + price + ", Status: " + availability();
    }
}

class Magazine extends LibraryItems {

    public Magazine(int itemId, String title, Double price) {
        super(itemId, title, price);
    }

    @Override
    String details() {
        return "Magazine ID: " + itemId + ", Title: " + title + ", Price: " + price + ", Status: " + availability();
    }
}

public class library {

    public static void main(String[] args) {
        ArrayList<LibraryItems> items = new ArrayList<>();

        
        items.add(new Book(101, "Java Programming", 450.0));
        items.add(new Book(102, "Python", 500.0));
        items.add(new Book(103, "C++", 300.0));
        items.add(new Magazine(201, "Marvel", 2000.0));

        items.get(1).borrow(); 
        items.get(3).borrow(); 
        items.get(3).returnItem(); 
        items.get(0).borrow();

        
        System.out.println("\nLibrary Inventory:");
        for (LibraryItems item : items) {
            System.out.println(item.details());
        }
    }
}
