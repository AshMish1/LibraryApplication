import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileInputOutput {
	private static Path booksPath = Paths.get("LibraryItems.txt");
	private static File booksFile = booksPath.toFile();

	public static void writeToFile(String title, String author, String genre, String status, int holds, LocalDate returnDate, LocalDate borrowDate, int id) {
		
		// write these parameters to a file using title,author,Genre,status,returnDate
		// format - no spaces
			PrintWriter printWriter = null;
			try {
				printWriter = new PrintWriter(new FileOutputStream("LibraryItems",true));
				printWriter.write(title + ", " + author + ", " + genre + ", "+ status + ", "+ holds + ", " +returnDate + "\n" +borrowDate + ", "+ id + ", ");
			} catch (IOException ioex) {
				ioex.printStackTrace();
			} finally {
				if (printWriter != null) {
					printWriter.flush();
					printWriter.close();
				}
			}
	}
	public static ArrayList<LibraryItem> getFile() {
			ArrayList<LibraryItem> books = new ArrayList<LibraryItem>();
			try (BufferedReader in = new BufferedReader(
					new FileReader(booksFile))) {
				String line = in.readLine();
				while (line != null) {
					String[] display = line.split(", ");
					LibraryItem book = new LibraryItem(display[0].trim(), display[1].trim(), display[2].trim(), display[3].trim(), Integer.parseInt(display[4].trim()), 
							LocalDate.parse(display[5].trim()), LocalDate.parse(display[6].trim()), Integer.parseInt(display[7].trim()));
					books.add(book);
					line = in.readLine();
				}
			}
			
			catch (IOException e) {
				System.out.println(e);
			}
			return books;
		}
//	public static void clearFile() throws IOException {
//		Files.delete(booksPath);
//	}
}
