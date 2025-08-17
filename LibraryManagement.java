import java.util.ArrayList;
import java.util.Scanner;

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

public class LibraryManagement {
    public static void main(String[] args) {
        ArrayList<LibraryItems> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========= Library Menu =========");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Display All Items");
            System.out.println("4. Search by Title");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String bTitle = scanner.nextLine();
                    System.out.print("Enter Book Price: ");
                    double bPrice = scanner.nextDouble();
                    items.add(new Book(bId, bTitle, bPrice));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Magazine ID: ");
                    int mId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Magazine Title: ");
                    String mTitle = scanner.nextLine();
                    System.out.print("Enter Magazine Price: ");
                    double mPrice = scanner.nextDouble();
                    items.add(new Magazine(mId, mTitle, mPrice));
                    System.out.println("Magazine added successfully.");
                    break;

                case 3:
                    System.out.println("\nLibrary Inventory:");
                    if (items.isEmpty()) {
                        System.out.println("No items in library.");
                    } else {
                        for (LibraryItems item : items) {
                            System.out.println(item.details());
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine().toLowerCase();
                    boolean found = false;
                    for (LibraryItems item : items) {
                        if (item.title.toLowerCase().contains(searchTitle)) {
                            System.out.println(item.details());
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No item found with title: " + searchTitle);
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
