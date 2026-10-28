package com.pluralsight;
import java.util.Scanner;

public class VehicleInventory {
    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[20];
        int vehicleCount = 0;

// Add the 6 vehicles
        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        vehicleCount = 6;
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Search by make/model");
            System.out.println("3 - Search by price range");
            System.out.println("4 - Search by color");
            System.out.println("5 - Add a vehicle");
            System.out.println("6 - Quit");
            System.out.print("Enter your command: ");

            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    for (int i = 0; i < vehicleCount; i++) {
                        System.out.println(
                                vehicles[i].getVehicleId() + " | " +
                                        vehicles[i].getMakeModel() + " | " +
                                        vehicles[i].getColor() + " | " +
                                        vehicles[i].getOdometerReading() + " miles | $" +
                                        vehicles[i].getPrice()
                        );
                    }
                    break;
                case 2:
                    scanner.nextLine();

                    System.out.print("Enter make/model: ");
                    String searchModel = scanner.nextLine();

                    boolean found = false;

                    for (int i = 0; i < vehicleCount; i++) {
                        if (vehicles[i].getMakeModel().equalsIgnoreCase(searchModel)) {
                            System.out.println(
                                    vehicles[i].getVehicleId() + " | " +
                                            vehicles[i].getMakeModel() + " | " +
                                            vehicles[i].getColor() + " | " +
                                            vehicles[i].getOdometerReading() + " miles | $" +
                                            vehicles[i].getPrice()
                            );
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No vehicle found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();

                    System.out.print("Enter maximum price: ");
                    double maxPrice = scanner.nextDouble();

                    boolean priceFound = false;

                    for (int i = 0; i < vehicleCount; i++) {
                        if (vehicles[i].getPrice() >= minPrice &&
                                vehicles[i].getPrice() <= maxPrice) {

                            System.out.println(
                                    vehicles[i].getVehicleId() + " | " +
                                            vehicles[i].getMakeModel() + " | " +
                                            vehicles[i].getColor() + " | " +
                                            vehicles[i].getOdometerReading() + " miles | $" +
                                            vehicles[i].getPrice()
                            );

                            priceFound = true;
                        }
                    }

                    if (!priceFound) {
                        System.out.println("No vehicles found in this price range.");
                    }
                    break;
                case 4:
                    System.out.println("Search by color");
                    break;
                case 5:
                    if (vehicleCount < 20) {
                        System.out.print("Enter vehicle ID: ");
                        long vehicleId = scanner.nextLong();
                        scanner.nextLine();

                        System.out.print("Enter make/model: ");
                        String makeModel = scanner.nextLine();

                        System.out.print("Enter color: ");
                        String color = scanner.nextLine();

                        System.out.print("Enter odometer reading: ");
                        int odometerReading = scanner.nextInt();

                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();

                        vehicles[vehicleCount] = new Vehicle(
                                vehicleId, makeModel, color, odometerReading, price
                        );

                        vehicleCount++;

                        System.out.println("Vehicle added successfully!");
                    } else {
                        System.out.println("Inventory is full.");
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
