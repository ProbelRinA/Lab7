package BookManager;

public class FictionalBook extends Book
{
    private String genre;

    public FictionalBook(String title, String author, int year, String genre)
    {
        super(title, author, year);
        this.genre = genre;
    }

    @Override
    public void printInfo()
    {
        System.out.println("Fiction Book Information:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Genre: " + genre + "\n");
    }
}
