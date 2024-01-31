package BookManager;

public class Main
{
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();

        FictionalBook fictionBook1 = new FictionalBook("1", "A", 1937, "Fantasy");
        FictionalBook fictionBook2 = new FictionalBook("2", "B", 2000, "Drama");
        NonFictionalBook nonFictionBook1 = new NonFictionalBook("3", "C", 2014, "History");
        NonFictionalBook nonFictionBook2 = new NonFictionalBook("4", "D", 1980, "Science");

        bookManager.addBook(fictionBook1);
        bookManager.addBook(fictionBook2);
        bookManager.addBook(nonFictionBook1);
        bookManager.addBook(nonFictionBook2);

        System.out.println("Information about all books:");
        bookManager.printAllBooks();

        bookManager.saveBooksToFile("D:/JAVA/Books.txt");

        BookManager loadedBookManager = new BookManager();
        loadedBookManager.loadBooksFromFile("D:/JAVA/Books.txt");

        System.out.println("\nInformation about loaded books:");
        loadedBookManager.printAllBooks();
    }
}
