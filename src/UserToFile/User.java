package UserToFile;

import java.io.*;
public class User
{
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;

    public User(String name, String surname, String username, String email, String password)
    {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void printInfo()
    {
        System.out.println("\nUser Information:");
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }

    public void saveToFile(String pathToFile)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathToFile, true)))
        {
            writer.println("Name: " + name);
            writer.println("Surname: " + surname);
            writer.println("Username: " + username);
            writer.println("Email: " + email);
            writer.println("Password: " + password + "\n");
            System.out.println("\nUser information saved to file.");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static boolean isValidEmail(String email)
    {
        return email.endsWith("@gmail.com");
    }
}
