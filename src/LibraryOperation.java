import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

// 
/**
 * The Class for all operations a library must implement
 */
public class LibraryOperation {

	public static String title;
	public static String author;
	public static String genre;
	public String status;
	public int holds;
	public LocalDate returnDate;
	public LocalDate borrowDate;
	public int id;
	

	private static final String consolePrompt = "> ";
	private static final String defaultPromt = "Enter input: ";
	private static final String defaultRetry = "Invalid Input. Try again.";

	Scanner userInput = new Scanner(System.in);
	/** The book choice. */
	public static int bookChoice;

	static String returnBookTitle;

	/** The status1. */
	static String status1 = "In";

	/** The status2. */
	static String status2 = "Out";

	static String status3 = "Missing";
	// Number to declare choice of user
	static int menuChoice;

	/** The book list. */
	static ArrayList<LibraryItem> bookList = new ArrayList<LibraryItem>();
	static ArrayList<LibraryItem> borrowedBooks = new ArrayList<LibraryItem>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void enterLibrary(){
		System.out.println("Hello! Welcome to the Library.\n\nHow can I help you?");
		
		ArrayList<LibraryItem> books = FileInputOutput.getFile();
		
		
		}
	
	
	
	/**
	 * Display Methods for console
	 * 
	 * @return BookInfo
	 */
	// display methods
	public static void displaySecondMenu() {
		System.out.println(">----------------------------Borrow Book------------------------------");
		System.out.println(">---------------------------------------------------------------------");
		System.out.println("> Choose one of the options below by typing the corresponding number: ");
		System.out.println(">---------------------------------------------------------------------");
		System.out.println("1- Check library list.");
		System.out.println("2- Search by title.");
		System.out.println("3- Search by author.");
		System.out.println("4- Search by keyword.");
		System.out.println("5- Search by genre.");
		System.out.println("6- Return to main menu.");
		System.out.println("0- Exit.");
		System.out.println(">---------------------------------------------------------------------");
		System.out.println("> Enter your option here: ");
	}

	// method for first menu
	public static void displayFirstMenu() {
		System.out.println(">------------------------------Main Menu------------------------------");
		System.out.println(">---------------------------------------------------------------------");
		System.out.println("> Choose one of the options below by typing the corresponding number: ");
		System.out.println(">---------------------------------------------------------------------");
		System.out.println("1- Check library list.");
		System.out.println("2- Borrow a book.");
		System.out.println("3- Return a book.");
		System.out.println("4- Donate a book to the Library.");
		System.out.println("5- Renue your book.");
		System.out.println("0- Exit.");
		System.out.println(">---------------------------------------------------------------------");
		System.out.println("> Enter your option here: ");
	}

	public String displayBook() {

		String BookInfo = "----------------------------" + "\nId:....................." + id
				+ "\nTitle:.................." + title + "\nAuthor:................." + author
				+ "\nGenre:.................." + genre + "\nStatus:................." + status
				+ "\nHolds:.................." + holds + "\nDate Borrowed:.........." + borrowDate
				+ "\nReturn date:............" + returnDate + "\n----------------------------";
		return BookInfo;
	}

	// display the menu options to the user
	static void displayMenu() {
	//	if (LibraryOperation.bookList.isEmpty()) {
			displayFirstMenu();
			/*LibraryOperation.menuChoice = LibraryOperation.readInteger(Messages.choiceMessage, Messages.tryAgainMessage,
					0, 5);*/
		} /*else if (LibraryOperation.bookList.size() > 0) {
			displaySecondMenu();
			LibraryOperation.menuChoice = LibraryOperation.readInteger(Messages.choiceMessage, Messages.tryAgainMessage,
					0, 6);*/
	//}

	/**
	 * Display book list.
	 */
	static void displayBookList() {
		if (bookList.isEmpty()) {// If the library is empty, it goes back to
									// main menu and choice.
			System.out.println(">-------------------------------------------------------------");
			System.out.println(Messages.empltyLibraryMessage + Messages.tryAgainMessage);
			System.out.println(">-------------------------------------------------------------");
			LibraryOperation.menuChoice = 7;

		} else {
			for (int i = 0; i < bookList.size(); i++) {
				System.out.printf("\n>-----------Book Index: [%s]---------------------------------\n", i);
				System.out.println(bookList.get(i).displayBook());
				System.out.println(">-------------------------------------------------------------");
			} // End of For Loop.
		} // End of Else Statement.
	}// End of if Statement.

	static void displayBorrowedBooks() {
		if (bookList.isEmpty()) {// If the library is empty, it goes back to
									// main menu and choice.
			System.out.println(">-------------------------------------------------------------");
			System.out.println(Messages.empltyLibraryMessage + Messages.tryAgainMessage);
			System.out.println(">-------------------------------------------------------------");
			LibraryOperation.menuChoice = 7;

		} else {
			for (int i = 0; i < bookList.size(); i++) {
				
				if (bookList.get(i).status.equalsIgnoreCase("Out")) {
					System.out.printf("\n>-----------Book Index: [%s]---------------------------------\n", i);
					System.out.println(bookList.get(i).displayBook());
					System.out.println(">-------------------------------------------------------------");
				}
			} // End of For Loop.
		} // End of Else Statement.
	}// End of if Statement.
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Creates the book.
	 */
	final void createBook() {

		title = LibraryOperation.readString(Messages.enterTitleMessage, Messages.tooShortMessage, 3);
		author = LibraryOperation.readString(Messages.enterAuthorMessage, Messages.tooShortMessage, 3);
		genre = LibraryOperation.readString(Messages.enterGenreMessage, Messages.tooShortMessage, 3);

		borrowDate = null;
		returnDate = null;
		status = "Available";
		holds = 0;
		id = bookList.size() + 1;

	}

	/**
	 * Adds the book.
	 */
	static void addBook() {
		LibraryItem newBook = new LibraryItem(title, author, genre); // create
																		// new
																		// book
																		// object
																		// with
																		// status
																		// "In."
		newBook.donateBook();
		bookList.add(newBook);// add the book to the BookList ArrayList.
		System.out.println("---------------------------------------------------------");
		System.out.println("> You have successfully added the book to the library!\n");
		System.out.println("---------------------------------------------------------");
	}

	public void donateBook() {
		System.out.println("> Enter the title of the book: ");
		Scanner in = userInput;
		title = userInput.nextLine();

		System.out.println("> Enter the author of the book: ");
		author = userInput.nextLine();

		System.out.println("> Enter the genre of the book: ");
		genre = userInput.nextLine();

		borrowDate = null;
		returnDate = null;
		status = "In";
		holds = 0;
		id = bookList.size() + 1;
	}

	/**
	 * Borrow book.
	 */
	public static void borrowBook() {
		System.out.println("---------------------------------------------------------");
		System.out.println("> Here are all the books registered in the library: ");
		System.out.println("---------------------------------------------------------");
		displayBookList();

		// register user's book choice.
		bookChoice = (LibraryOperation.readInteger(Messages.enterBookIndexMessage, Messages.bookIndexNotInListMessage,
				0, LibraryOperation.bookList.size()));

		//borrowLoop: while (LibraryOperation.menuChoice == 3) {
			// Check if the book to be borrowed is available.
			// bookChoice = (Console.readInteger(Messages.enterBookIndexMessage,
			// Messages.bookIndexNotInListMessage, 1, Library.bookList.size()));

			if ((bookList.get(bookChoice).status.equalsIgnoreCase(status1)) && (bookList.size() >= bookChoice)) {
				// Print the borrowed book information and change the book
				// status to borrowed.
				bookList.get(bookChoice).status = "Out";
				// date
				// ****bookList.getId.returnDate =
				bookList.get(bookChoice).borrowDate = LocalDate.now();
				bookList.get(bookChoice).returnDate = bookList.get(bookChoice).borrowDate.plusDays(14);
				// Add the borrowed book to the borrowedBooks arraylist:
				//borrowedBooks.add(bookList.get(bookChoice));

				System.out.printf("\n\n> You have chosen the following book:\n %s\n\n",
						bookList.get(bookChoice).displayBook());
				System.out.println("\n\n> You have to borrowed the book for 14 days.\nPlease return the item on: " + bookList.get(bookChoice).returnDate+"\n\n");

			} else if (bookList.get(bookChoice).status.equalsIgnoreCase(status2) && bookList.size() >= bookChoice) {
				System.out.println("\n\n<ERROR> The Book you are trying to borrow is unavailable.\n\n");

			} else if (bookChoice > bookList.size() - 1) {
				System.out.println(Messages.noSuchBookMessage);
			}
			
	//	}
		//LibraryOperation.displayMenu();
	}

	/**
	 * Return book.
	 */
	static void returnBook() {
		System.out.println("---------------------------------------------------------");
		System.out.println("> Borrowed Books: ");
		System.out.println("---------------------------------------------------------");
		displayBorrowedBooks();
		returnBookTitle = LibraryOperation.readString(Messages.enterTitleMessage, Messages.tooShortMessage, 3);

		int x = 0;
		boolean titleExistance = false;
		while (x < bookList.size()) {// Search for the book by title, if it
										// exists change it's status,
										// it's returnDate and borrowDate.

			if (bookList.get(x).title.equalsIgnoreCase(returnBookTitle)) {

				bookList.get(x).status = "In";
				// implement date/time sutff
				bookList.get(x).borrowDate = LocalDate.parse("2016-06-23");
				//bookList.get(x).returnDate = rDate;

				int p = 0;
				borrowLoop: while (p < borrowedBooks.size()) {// Search for the
																// book by
																// title, if it
																// exists change
																// it's status,
					// it's and borrowDate.

					if (borrowedBooks.get(p).title.equalsIgnoreCase(returnBookTitle)) {
						borrowedBooks.remove(p);
						break borrowLoop;
					}

				}
				System.out.println(Messages.successReturnMessage);
				titleExistance = true;

				break;// if a title is found, break out of the loop and display
						// choice menu.
			}
			x = x + 1;
		} // end of while loop.
		if (titleExistance == false) {
			boolean repeatReturnBook = LibraryOperation.readYesNo("<ERROR> The book: " + "\"" + returnBookTitle + "\""
					+ "was not found." + "\n> Do you want to try again? (Yes/No)? \n>");
		} else if (titleExistance) {
			LibraryOperation.menuChoice = 7; 
		}
	}

	/**
	 * Removes the book.
	 */
	public static void removeBook() {

		int i = 0;
		System.out.println("---------------------------------------------------------");
		System.out.println("> Here are all the books registered in the library: ");
		System.out.println("---------------------------------------------------------");

		while (i < bookList.size()) {// show the user the list of all the books
			displayBookList();
			i = i + 1;
		} // end of while loop.

		bookChoice = LibraryOperation.readInteger(Messages.enterRemoveBookIndex,
				Messages.bookIndexNotInListMessage + Messages.tryAgainMessage, 0, bookList.size());
		int p = 0;
		while (p < borrowedBooks.size()) {// Search for the book by title, if it
											// exists change it's status,
			// it's borrower and borrowDate.

			if (borrowedBooks.get(p).title.equalsIgnoreCase(returnBookTitle)) {

				borrowedBooks.remove(p);
			}
		}
		bookList.remove(bookChoice);
		System.out.print(Messages.successRemovedBookMessages);
		LibraryOperation.menuChoice = 7;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Method for dates
	public static LocalDate borrowDate(){
        return LocalDate.now();
        
    }

    public static LocalDate returnDate() {
        return LocalDate.now().plusDays(14);
    }
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Methods for inputs

	// check if the user wants yes or no
	public static boolean readYesNo(String prompt) {
		String input = readLine(prompt).toLowerCase().trim();
		if (input.equals("yes") || input.equals("y")) {
			return true;
		}
		// Behavioral: only 'yes' will return true.
		// It does not recurse on invalid input because incorrect input
		// is same as 'no'
		return false;
	}

	/**
	 * Prompts the user for an Integer input in a given range.
	 *
	 * @param prompt
	 *            The message asking for user input.
	 * @param error
	 *            The error message to inform the user that the input was
	 *            invalid.
	 * @param min
	 *            The minimum valid input
	 * @param max
	 *            The maximum valid input
	 * @return An integer in the range min..max
	 */
	public static int readInteger(String prompt, String error, int min, int max) {
		if (min >= max) {
			return 0; // Should not happen, but can if the client programmer is
						// not paying attention
		}

		try {
			int i = Integer.valueOf((readLine(prompt)));
			if ((i < min) || (i > max)) {
				System.out.println(error);
				return readInteger(prompt, error, min, max);
			}
			return i;
		} catch (NumberFormatException e) {
			System.out.println(error);
			return readInteger(prompt, error, min, max);
		}
	}

	/**
	 * Prompts the user for an Integer input in a given range.
	 *
	 * @param prompt
	 *            The message asking for user input.
	 * @param min
	 *            The minimum valid input.
	 * @param max
	 *            The maximum valid input.
	 * @return An integer in the range min..max
	 */
	public static int readInteger(String prompt, int min, int max) {
		return readInteger(prompt, defaultRetry, min, max);
	}

	/**
	 * Prompts the user for an Integer input in a given range.
	 *
	 * @param min
	 *            The minimum valid input.
	 * @param max
	 *            The maximum valid input.
	 * @return An integer in the range min..max
	 */
	public static int readInteger(int min, int max) {
		return readInteger(defaultPromt, defaultRetry, min, max);
	}

	/**
	 * Prompts the user for an Integer input.
	 *
	 * @param prompt
	 *            The message asking for user input.
	 * @param error
	 *            The error message to inform the user that the input was
	 *            invalid.
	 * @return An integer
	 */
	public static int readInteger(String prompt, String error) {
		try {
			return Integer.valueOf((readLine(prompt)));
		} catch (NumberFormatException e) {
			System.out.println("\n" + error);
			return readInteger(prompt, error);
		}
	}

	/**
	 * Prompts the user for an Integer input.
	 *
	 * @param prompt
	 *            The message asking for user input.
	 * @return An integer
	 */
	public static int readInteger(String prompt) {
		return readInteger(prompt, defaultRetry);
	}

	/**
	 * Prompts the user for an Integer input.
	 *
	 * @return An integer
	 */
	public static int readInteger() {
		return readInteger(defaultPromt, defaultRetry);
	}

	/**
	 * Prompts the user for a String input at least minLength in size.
	 *
	 * @param prompt
	 *            The message asking for user input.
	 * @param error
	 *            The message informing the user about invalid input
	 * @param minLength
	 *            The minimum length of the string that is valid
	 * @return A string minLength or greater in length
	 */
	public static String readString(String prompt, String error, int minLength) {
		String input = readLine(prompt);
		if (input.length() < minLength) {
			System.out.println("\n" + error);
			return readString(prompt, error, minLength);
		}

		return input;
	}

	/**
	 * Prompts the user for a String input. It will prompt again if the user
	 * does not enter anything
	 *
	 * @param prompt
	 *            The message asking for user input.
	 * @param error
	 *            The message informing the user of invalid input
	 * @return A String
	 */
	public static String readString(String prompt, String error) {
		String input = readLine(prompt);
		if ((input.length() == 0) || (input == null) || (input.equals("\n"))) {
			System.out.println("\n" + error);
		}

		return input;
	}

	/**
	 * Prompts the user for a String input.
	 *
	 * @param prompt
	 *            The message asking for user input.
	 * @return A String
	 */
	public static String readString(String prompt) {
		return readString(prompt, defaultRetry);
	}

	/**
	 * Prompts the user for a String input.
	 *
	 * @return A String
	 */
	public static String readString() {
		return readString(defaultPromt, defaultRetry);
	}

	/**
	 * Working method, used by every single method in this class. It uses the
	 * low level System.in.read() to build a StringBuffer containing the users
	 * input and traps the user in an loop until ENTER is pressed. In windows,
	 * the ENTER button returns /r/n which is dealt with in the loop.
	 */
	public static String readLine(String prompt) {
		System.out.print(prompt);
		System.out.print("\n");
		System.out.print(consolePrompt);

		StringBuffer b = new StringBuffer();
		while (true) {
			try {
				char c = (char) System.in.read();
				b.append(c);
				if (c == '\n') {
					return b.toString().trim(); // Enter pressed
				} else if (c == '\r') {
				} // Windows carriage return \r is followed by \n so we ignore
					// it and pick it up on the next loop
			} catch (IOException e) {
			} // Unsure what would cause this and what to do about it
		}
	}

	/***
	 * Runs the main part of the program and terminates if the choice is 0.
	 */
	public static void run() {
		
		LibraryOperation.displayMenu();// Displays the main menu and ask for
										// choice.
		LibraryOperation.bookList = FileInputOutput.getFile();

		Scanner mc = new Scanner(System.in);
		LibraryOperation.menuChoice  = mc.nextInt();
		while (LibraryOperation.menuChoice != 0) {

			// Choice 1: Check library list:

			if (LibraryOperation.menuChoice == 1 && LibraryOperation.bookList.size() > 0) {
				LibraryOperation.displayBookList();
				LibraryOperation.displayMenu();
				LibraryOperation.menuChoice  = mc.nextInt();
			}

			if (LibraryOperation.menuChoice == 1 && LibraryOperation.bookList.isEmpty()) {
				System.out.println(Messages.invalidInputMessage);
				LibraryOperation.displayMenu();
				LibraryOperation.menuChoice  = mc.nextInt();
			}

			// Choice 2: Borrow a book:

			if (LibraryOperation.menuChoice == 2 && LibraryOperation.bookList.size() > 0) {
				LibraryOperation.borrowBook();
			}

			if (LibraryOperation.menuChoice == 2 && LibraryOperation.bookList.isEmpty()) {
				System.out.println(Messages.invalidInputMessage);
				//LibraryOperation.displayMenu();
				
			}

			// Choice 3: Return a book:

			if (LibraryOperation.menuChoice == 3 && LibraryOperation.bookList.size() > 0) {
				LibraryOperation.returnBook();
				//LibraryOperation.displayMenu();
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

			/*if (LibraryOperation.menuChoice == 5 && LibraryOperation.bookList.size() > 0) {
				LibraryOperation.renueBook();
			}*/

			if (LibraryOperation.menuChoice == 5 && LibraryOperation.bookList.isEmpty()) {
				System.out.println(Messages.invalidInputMessage);
				LibraryOperation.displayMenu();
			}

			// Choice 6: Display main Menu:

			LibraryOperation.displayFirstMenu();
			LibraryOperation.menuChoice  = mc.nextInt();
			// Choice 0: Exit the program:

			/*if (LibraryOperation.menuChoice == 0) {
				break;
			}*/
			
		}// end of while loop.
		
		FileInputOutput.writeToFile(bookList);
		System.out.println("\n\n");
		System.out.println("You have Exited the Library!\nThank");
		System.out.println("\n\n");

	}// End of run() method.

}