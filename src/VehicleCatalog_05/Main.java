package VehicleCatalog_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();
        int cars = 0;
        int trucks = 0;
        int carsHp = 0;
        int trucksHp = 0;

        while (true) {
            String[] elements = sc.nextLine().split("\\s+");
            if (elements[0].equals("End")) {
                break;
            }
            String type = elements[0];
            String model = elements[1];
            String color = elements[2];
            int horsePower = Integer.parseInt(elements[3]);

            Vehicle car = new Vehicle(type, model, color, horsePower);
            vehicles.add(car);

            if (type.equals("car")) {
                cars++;
                carsHp += horsePower;
            } else {
                trucks++;
                trucksHp += horsePower;
            }
        }

        while (true) {
            String model = sc.nextLine();
            if (model.equals("Close the Catalogue")) {
                break;
            }
            List<Vehicle> currentVehicle = vehicles.stream()
                    .filter(vehicle -> vehicle.getModel().equals(model)).collect(Collectors.toList());

            System.out.println(currentVehicle.toString().replaceAll("[\\[\\]]", ""));

        }
        double averageCarsHP = (double) carsHp / cars;
        double averageTruckHP = 0;
        if (trucks != 0) {
            averageTruckHP = (double) trucksHp / trucks;
        }
        System.out.printf("Cars have average horsepower of: %.2f.\n", averageCarsHP);
        System.out.printf("Trucks have average horsepower of: %.2f.\n", averageTruckHP);

    }
}
