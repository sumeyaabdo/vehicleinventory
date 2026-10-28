package com.pluralsight;

import java.util.Scanner;

public class VehicleInventory {

    static int numberOfVehiclesInInventory = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create an array for 20 vehicles
        Vehicle[] inventory = new Vehicle[20];

        // Add 6 vehicles
        inventory[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        inventory[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        inventory[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        inventory[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        inventory[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        inventory[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        numberOfVehiclesInInventory = 6;

        boolean appRunning = true;

        while (appRunning) {

            System.out.println("\nWhat do you want to do?");
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Search by make/model");
            System.out.println("3 - Search by price range");
            System.out.println("4 - Search by color");
            System.out.println("5 - Add a vehicle");
            System.out.println("6 - Quit");
            System.out.print("Enter your command: ");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1 -> listAllVehicles(inventory);
                case 2 -> searchByModel(scanner, inventory);
                case 3 -> searchByPrice(scanner, inventory);
                case 4 -> searchByColor(scanner, inventory);
                case 5 -> addVehicle(scanner, inventory);
                case 6 -> appRunning = false;
                default -> System.out.println("Invalid command");
            }
        }

        scanner.close();
    }

    // Option 1 - List all vehicles
    public static void listAllVehicles(Vehicle[] inventory) {

        for (int i = 0; i < numberOfVehiclesInInventory; i++) {

            System.out.println(
                    inventory[i].getVehicleId() + " | " +
                            inventory[i].getMakeModel() + " | " +
                            inventory[i].getColor() + " | " +
                            inventory[i].getOdometerReading() + " miles | $" +
                            inventory[i].getPrice()
            );
        }
    }

    // Option 2 - Search by make/model
    public static void searchByModel(Scanner scanner, Vehicle[] inventory) {

        System.out.print("Please enter the make/model: ");
        String makeModel = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < numberOfVehiclesInInventory; i++) {

            if (inventory[i].getMakeModel().equalsIgnoreCase(makeModel)) {

                System.out.println(
                        inventory[i].getVehicleId() + " | " +
                                inventory[i].getMakeModel() + " | " +
                                inventory[i].getColor() + " | " +
                                inventory[i].getOdometerReading() + " miles | $" +
                                inventory[i].getPrice()
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicle found.");
        }
    }

    // Option 3 - Search by price range
    public static void searchByPrice(Scanner scanner, Vehicle[] inventory) {

        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();

        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        boolean found = false;

        for (int i = 0; i < numberOfVehiclesInInventory; i++) {

            if (inventory[i].getPrice() >= minPrice &&
                    inventory[i].getPrice() <= maxPrice) {

                System.out.println(
                        inventory[i].getVehicleId() + " | " +
                                inventory[i].getMakeModel() + " | " +
                                inventory[i].getColor() + " | " +
                                inventory[i].getOdometerReading() + " miles | $" +
                                inventory[i].getPrice()
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found in this price range.");
        }
    }

    // Option 4 - Search by color
    public static void searchByColor(Scanner scanner, Vehicle[] inventory) {

        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < numberOfVehiclesInInventory; i++) {

            if (inventory[i].getColor().equalsIgnoreCase(color)) {

                System.out.println(
                        inventory[i].getVehicleId() + " | " +
                                inventory[i].getMakeModel() + " | " +
                                inventory[i].getColor() + " | " +
                                inventory[i].getOdometerReading() + " miles | $" +
                                inventory[i].getPrice()
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found with this color.");
        }
    }

    // Option 5 - Add a vehicle
    public static void addVehicle(Scanner scanner, Vehicle[] inventory) {

        if (numberOfVehiclesInInventory < 20) {

            System.out.print("Please enter the vehicle ID: ");
            long vehicleId = scanner.nextLong();
            scanner.nextLine();

            System.out.print("Please enter the make/model: ");
            String makeModel = scanner.nextLine();

            System.out.print("Please enter the color: ");
            String color = scanner.nextLine();

            System.out.print("Please enter the odometer reading: ");
            int odometerReading = scanner.nextInt();

            System.out.print("Please enter the price: ");
            double price = scanner.nextDouble();

            Vehicle newVehicle = new Vehicle(
                    vehicleId, makeModel, color, odometerReading, price
            );

            inventory[numberOfVehiclesInInventory] = newVehicle;

            numberOfVehiclesInInventory++;

            System.out.println("Vehicle added successfully!");

        } else {
            System.out.println("Inventory is full.");
        }
    }
}