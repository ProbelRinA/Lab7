package BookManager;

import java.io.*;
import java.util.ArrayList;

public class BookManager implements Serializable
{
    private ArrayList<Book> books;

    public BookManager()
    {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    public void printAllBooks()
    {
        for (Book book : books)
        {
            book.printInfo();
        }
    }

    public void saveBooksToFile(String pathToFile)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathToFile)))
        {
            for (Book book : books)
            {
                writer.println("Title: " + book.title);
                writer.println("Author: " + book.author);
                writer.println("Year: " + book.year + "\n");
            }
            System.out.println("\nBook information saved to file.");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadBooksFromFile(String pathToFile)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (line.startsWith("Title: "))
                {
                    String title = line.substring("Title: ".length());

                    String authorLine = reader.readLine();
                    String author = authorLine.substring("Author: ".length());

                    String yearLine = reader.readLine();
                    int year = Integer.parseInt(yearLine.substring("Year: ".length()));

                    reader.readLine();

                    if (title.equals("Fiction Book Information:"))
                    {
                        String genreLine = reader.readLine();
                        String genre = genreLine.substring("Genre: ".length());
                        addBook(new FictionalBook(title, author, year, genre));
                    } else
                    {
                        String topicLine = reader.readLine();
                        String topic = topicLine.substring("Topic: ".length());
                        addBook(new NonFictionalBook(title, author, year, topic));
                    }
                }
            }
            System.out.println("\nBook information loaded from file.");
        } catch (IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
    }
}
