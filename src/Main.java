import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static class Engine {
        String model;
        int power;
        String displacement;
        String efficiency;

        public Engine(String model, int power) {
            this.model = model;
            this.power = power;
            this.displacement = "n/a";
            this.efficiency = "n/a";
        }

        public Engine(String model, int power, String displacement) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = "n/a";
        }

        public Engine(String model, int power, String displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }
        public String toString() {
            return String.format("  %s:%n    Power: %d%n    Displacement: %s%n    Efficiency: %s",
                    model, power, displacement, efficiency);
        }
    }
    public static class Car {
        String model;
        Engine engine;
        String weight;
        String colour;

        public Car(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
            this.weight = "n/a";
            this.colour = "n/a";
        }

        public Car(String model, Engine engine, String weight) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.colour = "n/a";
        }

        public Car(String model, Engine engine, String weight, String colour) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.colour = colour;
        }

        public String toString() {
            return String.format("%s:%n%s%n  Weight: %s%n  Color: %s",
                    model, engine.toString(), weight, colour);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engineMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            Engine engine;
            if (input.length == 2) {
                engine = new Engine(model,power);
            } else if (input.length == 3) {
                String data = input[2];
                if (Character.isDigit(data.charAt(0))) {
                    engine = new Engine(model,power, data);
                } else {
                    engine = new Engine(model, power, "n/a", data);
                }
            } else {
                engine = new Engine(model, power, input[2], input[3]);
            }
            engineMap.put(model, engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            Engine engine = engineMap.get(input[1]);
            Car car;
            if (input.length == 2) {
                car = new Car(model,engine);
            } else if (input.length == 3) {
                String data = input[2];
                if (Character.isDigit(data.charAt(0))) {
                    car = new Car(model, engine, data, "n/a");
                } else {
                    car = new Car(model,engine,"n/a", data);
                }
            }  else {
                car = new Car(model, engine, input[2], input[3]);
            }
            System.out.println(car);
        }
    }
}