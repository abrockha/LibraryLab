import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
	String address;
	ArrayList<Book> books = new ArrayList<Book>();
	
    public Library(String address) {
    	this.address = address;
	}

	public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }

	private void returnBook(String title) {
		String borrowTitle = title;
		String bookTitle;
		
		for (int i = 0; i < books.size(); i++) {
			Book book = this.books.get(i);
			bookTitle = book.getTitle();
			if(borrowTitle.equals(bookTitle)) {
				book.returned();
				System.out.println("You successfully returned The Lord of the Rings.");
			}
		}
	}

	private void printAvailableBooks() {
		for (int i = 0; i <books.size(); i++){
			Book book = this.books.get(i);
			if(book.isBorrowed()) {
				
			}
			else {
				System.out.println(book.getTitle());
			}
		}
		if(books.size() == 0) {
			System.out.println("No book in catalog.");
		}
	}

	private void borrowBook(String title) {
		String bookTitle;
		String borrowTitle = title;
		boolean bookIsHere = false;
		for (int i = 0; i < books.size(); i++) {
			Book book = this.books.get(i);
			bookTitle = book.getTitle();
			
			if(borrowTitle.equals(bookTitle)) {
				bookIsHere = true;
				if (book.isBorrowed()) {
					System.out.println("Sorry, this book is already borrowed.");
				}
				else if (!(book.isBorrowed())) {
					book.rented();
					System.out.println("You successfully borrowed The Lord of the Rings.");
				}	
			}
		}
		if(bookIsHere == false) {
			
			System.out.println("Sorry, this book is not in our catalog.");
		}
	}

	private void printAddress() {
		System.out.println(this.address);
		
	}

	private static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
		
		
	}

	private void addBook(Book bookTitle) {
		Book book = bookTitle;
		this.books.add(book);
	}
}