import java.time.LocalDate;
import java.util.Scanner;

//books in the library

public class LibraryItem {
	public String title;
	public String author;
	public String genre;
	public String status;
	public int holds;
	public LocalDate returnDate;
	public LocalDate borrowDate;
	public int id;

	/**
	 * @param title
	 * @param author
	 * @param genre
	 * @param status
	 * @param holds
	 * @param dueDate
	 * @param checkoutDate
	 * @param id
	 */
	public LibraryItem(String title, String author, String genre, String status, int holds, LocalDate returnDate, LocalDate borrowDate, int id) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.status = status;
		this.holds = holds;
		this.returnDate = returnDate;
		this.borrowDate = borrowDate;
		this.id = id;
	}

	// Constructor for donating new books
	public LibraryItem(String title, String author, String genre) {
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the holds
	 */
	public int getHolds() {
		return holds;
	}

	/**
	 * @param holds
	 *            the holds to set
	 */
	public void setHolds(int holds) {
		this.holds = holds;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	
	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * @return the borrowDate
	 */
	public LocalDate getCheckoutDate() {
		return borrowDate;
	}

	/**
	 * @param borrowDate
	 *            the borrowDate to set
	 */
	public void setCheckoutDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}	
	//
	//Method to add new book to list
	public void donateBook(){
		System.out.println("> Enter the title of the book: ");
		Scanner userInput = null;
		title = userInput.nextLine();
 
		System.out.println("> Enter the author of the book: ");
		author = userInput.nextLine();
 
		System.out.println("> Enter the genre of the book: ");
		genre = userInput.nextLine();
 
		borrowDate = null;
		returnDate = null;
		status = "In";
		holds=0;	
	}
	public String displayBook() {

		String BookInfo = "----------------------------" + "\nTitle:.................." + title
				+ "\nAuthor:................." + author + "\nGenre:.................." + genre
				+ "\nStatus:................." + status + "\nHolds:.................." + holds
				+ "\nDate Borrowed:.........." + borrowDate + "\nReturn date:............" + returnDate
				+ "\nId:....................." + id + "\n----------------------------";
		return BookInfo;
	}
	public void run() {

		LibraryOperation.displayMenu();// Displays the main menu and ask for
										// choice.

		exit: while (LibraryOperation.menuChoice != 0) {

			// Choice 1: Check library list:

			if (LibraryOperation.menuChoice == 1 && LibraryOperation.bookList.size() > 0) {
				LibraryOperation.displayBookList();
				LibraryOperation.displayMenu();
			}

			if (LibraryOperation.menuChoice == 1 && LibraryOperation.bookList.isEmpty()) {
				System.out.println(Messages.invalidInputMessage);
				LibraryOperation.displayMenu();
			}

			// Choice 2: Borrow a book:

			if (LibraryOperation.menuChoice == 2 && LibraryOperation.bookList.size() > 0) {
				LibraryOperation.borrowBook();
			}

			if (LibraryOperation.menuChoice == 2 && LibraryOperation.bookList.isEmpty()) {
				System.out.println(Messages.invalidInputMessage);
				LibraryOperation.displayMenu();
			}

			// Choice 3: Return a book:

			if (LibraryOperation.menuChoice == 3 && LibraryOperation.bookList.size() > 0
					&& LibraryOperation.borrowedBooks.size() > 0) {
				LibraryOperation.returnBook();
				LibraryOperation.displayMenu();
			}

			if (LibraryOperation.menuChoice == 3 && LibraryOperation.bookList.isEmpty()) {
				System.out.println(Messages.invalidInputMessage);
				LibraryOperation.displayMenu();
			}

			// Choice 4: donate a book:

			if (LibraryOperation.menuChoice == 4) {
				// createBook();
				LibraryOperation.addBook();
				LibraryOperation.displayMenu();
			}
			// Choice 5: Renue a book:

			if (LibraryOperation.menuChoice == 5 && LibraryOperation.bookList.size() > 0) {
				System.out.println("Sorry this choice is not yet implemented.");
			}

			if (LibraryOperation.menuChoice == 5 && LibraryOperation.bookList.isEmpty()) {
				System.out.println(Messages.invalidInputMessage);
				LibraryOperation.displayMenu();
			}

			// Choice 6: Display main Menu:

			if (LibraryOperation.menuChoice == 7) {
				if (LibraryOperation.bookList.size() > 0) {
					LibraryOperation.displayMenu();
				} else if (LibraryOperation.bookList.isEmpty()) {
					LibraryOperation.displayMenu();
				}
			}

			// Choice 0: Exit the program:

			if (LibraryOperation.menuChoice == 0) {
				break exit;
			}

		} // end of while loop.
		System.out.println("\n\n\n\n\n");
		System.out.println("You have Exited the Library!");
		System.out.println("\n\n\n\n\n");

	}// End of run() method.
}