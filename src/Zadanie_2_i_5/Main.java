package Zadanie_2_i_5;

public class Main
{
    public static void main(String[] args)
    {
        Car car1 = new Car("John", "Doe", 30, "12345678901", "ABC123", 2022, "Toyota", "Camry");

        car1.printInfo();

        car1.printCarInfo();

        Driver driver = new Driver("John", "Doe", 30, "12345678901");
        driver.printInfo();
        driver.saveToFile("D:/JAVA/Driver.txt");

        Driver loadedDriver = Driver.loadFromFile("D:/JAVA/Driver.txt");
        if (loadedDriver != null) {
            loadedDriver.printInfo();
        }

        Car car2 = new Car("John", "Doe", 30, "12345678901", "ABC123", 2022, "Toyota", "Camry");
        car2.printCarInfo();
        car2.saveCarToFile("D:/JAVA/Car.txt");

        Car loadedCar = Car.loadCarFromFile("D:/JAVA/car.txt");
        if (loadedCar != null) {
            loadedCar.printCarInfo();
        }
    }
}
