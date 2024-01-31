package Zadanie_2_i_5;

import java.io.*;

public class Car extends Driver implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String vin;
    protected int year;
    public String brand;
    public String model;

    public Car(String name, String surname, int age, String pesel, String vin, int year, String brand, String model)
    {
        super(name, surname, age, pesel);
        this.vin = vin;
        this.year = year;
        this.brand = brand;
        this.model = model;
    }

    public void printCarInfo()
    {
        System.out.println("\nCar Info:");
        System.out.println("VIN: " + vin);
        System.out.println("Year: " + year);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }

    public void saveCarToFile(String pathToFile)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathToFile)))
        {
            writer.println("Name: " + getName());
            writer.println("Surname: " + surname);
            writer.println("Age: " + age);
            writer.println("PESEL: " + pesel);
            writer.println("VIN: " + vin);
            writer.println("Year: " + year);
            writer.println("Brand: " + brand);
            writer.println("Model: " + model);
            System.out.println("\nCar information saved to file.");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Car loadCarFromFile(String pathToFile)
    {
        Car car = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile)))
        {
            String line;
            String loadedName = null, loadedSurname = null, loadedPesel = null;
            String loadedVin = null, loadedBrand = null, loadedModel = null;
            int loadedAge = 0, loadedYear = 0;

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
                        case "VIN":
                            loadedVin = value;
                            break;
                        case "Year":
                            loadedYear = Integer.parseInt(value);
                            break;
                        case "Brand":
                            loadedBrand = value;
                            break;
                        case "Model":
                            loadedModel = value;
                            break;
                    }
                }
            }

            if (loadedName != null && loadedSurname != null && loadedPesel != null &&
                    loadedVin != null && loadedYear != 0 && loadedBrand != null && loadedModel != null)
            {
                car = new Car(loadedName, loadedSurname, loadedAge, loadedPesel, loadedVin, loadedYear, loadedBrand, loadedModel);
                System.out.println("\nCar information loaded from file.");
            }
        } catch (IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
        
        return car;
    }
}
