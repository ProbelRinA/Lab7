package UserToFile;

import  java.util.Scanner;
public class UserToFile
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter user information:");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Surname: ");
        String surname = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (User.isValidEmail(email))
        {
            System.out.print("Password: ");
            String password = scanner.nextLine();

            User newUser = new User(name, surname, username, email, password);

            newUser.saveToFile("D:/JAVA/UserInfo.txt");

            newUser.printInfo();
        } else
        {
            System.out.println("\nEmail is invalid.");
        }
    }
}
