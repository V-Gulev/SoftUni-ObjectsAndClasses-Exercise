import java.util.*;

public class Main {
    static class Engine {
        int speed;
        int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }
    }

    static class Cargo {
        int weight;
        String type;

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }
    }

    static class Tires {
        int age;
        double pressure;

        public Tires(int age, double pressure) {
            this.age = age;
            this.pressure = pressure;
        }
    }

    static class Car {
        private String model;
        Engine engine;
        Cargo cargo;
        Tires[] tires;

        public Car(String model, Engine engine, Cargo cargo, Tires[] tires) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tires = tires;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split(" ");
            String model = carInfo[0];
            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];

            Tires[] tires = new Tires[4];
            for (int j = 0; j < 4; j++) {
                double pressure = Double.parseDouble(carInfo[5 + j * 2]);
                int age = Integer.parseInt(carInfo[6 + j * 2]);
                tires[j] = new Tires(age, pressure);
            }
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Car car = new Car(model, engine, cargo, tires);

            cars.add(car);
        }

        String typeOfCargo = scanner.nextLine();

        if (typeOfCargo.equals("fragile")) {
            cars.stream()
                    .filter(car -> car.cargo.type.equals("fragile"))
                    .filter(car -> {
                        for (Tires tire : car.tires) {
                            if (tire.pressure < 1) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .forEach(car -> System.out.println(car.model));
        } else if (typeOfCargo.equals("flamable")) {
            cars.stream()
                    .filter(car -> car.cargo.type.equals("flamable"))
                    .filter(car -> car.engine.power > 250)
                    .forEach(car -> System.out.println(car.model));
        }
    }
}