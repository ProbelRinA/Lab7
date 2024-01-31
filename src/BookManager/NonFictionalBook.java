package BookManager;

public class NonFictionalBook extends Book
{
    private String topic;

    public NonFictionalBook(String title, String author, int year, String topic)
    {
        super(title, author, year);
        this.topic = topic;
    }

    @Override
    public void printInfo()
    {
        System.out.println("Non-Fiction Book Information:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Topic: " + topic);
        System.out.println();
    }
}
