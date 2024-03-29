package BookManager;

import java.io.Serializable;

abstract class Book implements Serializable
{
    protected String title;
    protected String author;
    protected int year;

    public Book(String title, String author, int year)
    {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public abstract void printInfo();
}