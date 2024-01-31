package Zadanie_2_i_5;

import java.io.*;

public class Driver implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String name;
    protected String surname;
    public int age;
    public String pesel;

    public Driver(String name, String surname, int age, String pesel) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.pesel = pesel;
    }

    public String getName()
    {
        return name;
    }

    public void printInfo() {
        System.out.println("\nDriver Info:");
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Age: " + age);
        System.out.println("PESEL: " + pesel);
    }

    public void saveToFile(String pathToFile)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathToFile)))
        {
            writer.println("Name: " + name);
            writer.println("Surname: " + surname);
            writer.println("Age: " + age);
            writer.println("PESEL: " + pesel);
            System.out.println("\nDriver information saved to file.");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Driver loadFromFile(String pathToFile)
    {
        Driver driver = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile)))
        {
            String line;
            String loadedName = null, loadedSurname = null, loadedPesel = null;
            int loadedAge = 0;

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(": ");
                if (parts.length == 2)
                {
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    switch (key)
                    {
                        case "Name":
                            loadedName = value;
                            break;
                        case "Surname":
                            loadedSurname = value;
                            break;
                        case "Age":
                            loadedAge = Integer.parseInt(value);
                            break;
                        case "PESEL":
                            loadedPesel = value;
                            break;
                    }
                }
            }

            if (loadedName != null && loadedSurname != null && loadedPesel != null)
            {
                driver = new Driver(loadedName, loadedSurname, loadedAge, loadedPesel);
                System.out.println("\nDriver information loaded from file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return driver;
    }
}

