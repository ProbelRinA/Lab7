package ObjectArrayToFile;

import java.io.*;

public class ArrayToFile
{
    public static void saveArrayToFile(String pathToFile, Person[] array)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathToFile)))
        {
            for (Person person : array)
            {
                writer.println(person.name + "," + person.age);
            }
            System.out.println("Array has been saved to the file.");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Person[] loadArrayFromFile(String pathToFile)
    {
        Person[] array = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile)))
        {
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");

                if (array == null)
                {
                    array = new Person[1];
                } else
                {
                    Person[] newArray = new Person[array.length + 1];
                    System.arraycopy(array, 0, newArray, 0, array.length);
                    array = newArray;
                }

                array[index++] = new Person(parts[0], Integer.parseInt(parts[1]));
            }

            System.out.println("Array has been loaded from file.");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return array;
    }

    public static void main(String[] args)
    {
        Person[] persons =
                {
                        new Person("John", 25),
                        new Person("Alice", 30),
                        new Person("Fiona", 28)
                };

        saveArrayToFile("D:/JAVA/ObjectArrayList.txt", persons);

        Person[] loadedPersons = loadArrayFromFile("D:/JAVA/ObjectArrayList.txt");

        if (loadedPersons != null)
        {
            System.out.println("Loaded Array: ");
            for (Person person : loadedPersons)
            {
                System.out.println(person);
            }
        }
    }
}
