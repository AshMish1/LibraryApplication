import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class LibraryApplication {
	public static void main(String[] args) {
		
		
		System.out.println("Hello! Welcome to the Library.\n\nHow can I help you?");
		

		LibraryOperation.run();
		
		
	//	ArrayList<LibraryItem> books = FileInputOutput.getFile();
		
		
		
		}
	}



		/*BufferedReader bookbr = null;

		try {
			String book;
			bookbr = new BufferedReader(new FileReader("books.txt"));
			// How to read file in java line by line?
			while ((book = bookbr.readLine()) != null) {
				System.out.println("Raw data: " + book);
				System.out.println("Data in ArrayList: " + dataToArrayList(book) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bookbr != null)
					bookbr.close();
			} catch (IOException crunchifyException) {
				crunchifyException.printStackTrace();
			}
		}
	}

	// Utility which converts CSV to ArrayList using Split Operation
	public static ArrayList<String> dataToArrayList(String book) {
		ArrayList<String> crunchifyResult = new ArrayList<String>();

		if (book != null) {
			String[] splitData = book.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					crunchifyResult.add(splitData[i].trim());
				}
			}
		}

		return crunchifyResult;
	}
	// greeting
	System.out.println("Welcome to the library");

	// display 12 books by title
	// handle file io here
	Path booksPath = Paths.get("./books.txt");

	File booksFile = booksPath.toFile();

	// System.out.println(booksFile);

	ArrayList<LibraryItem> bookList = new ArrayList<LibraryItem> ();
	try
	{
		FileReader r = new FileReader(booksFile);
		BufferedReader in = new BufferedReader(r);
		String line = in.readLine();
		while (line != null) {
			// System.out.println(line);
			String[] details = line.split(", ");

			// System.out.println();
			// take the String, parse it as a double, then store it
			// line below built into second const.
			// double price = Double.parseDouble(details[2]);
			// create a new instance with this info
			LibraryItem temp = new LibraryItem(details[0], details[1], details[2]);
			// add this instance into the list
			bookList.add(temp);

			// read the next line for the next loop
			line = in.readLine();
		}
		in.close();
	}catch(
	IOException e)
	{
		System.out.println(e);
	}

	System.out.println();

	// output everything
	for(
	LibraryItem p:bookList)
	{
		System.out.println(p.getAuthor());// implicit call to toString();
	}

	// System.out.println("Title only:");
	// one category
	for(
	LibraryItem p:bookList)
	{
		if (p.getTitle().equals("Title"))
			System.out.println(p);// implicit call to toString();
	}
}}

// ask what user wants to do
// search by author
// title
// status
// keyword

// return choice

// select book to checkout
// if status is checked out (display status)
// if status is available set due date to 2 weeks from the date
// print title and due date

// prompt to continue y/n

//
*/