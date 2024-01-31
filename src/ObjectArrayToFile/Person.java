package ObjectArrayToFile;

import java.io.Serializable;

public class Person implements Serializable
{
    private static final long serialVersionUID = 1L;

    public String name;
    public int age;

    public Person(String name, int age)
    {
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString()
    {
        return "Name: " + name + "\nAge: " + age;
    }
}
