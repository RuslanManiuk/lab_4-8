package TaxiFleet;

import Car.*;

import java.util.ArrayList;
import java.util.List;

public class TaxiFleet {
    private List<Car> cars;
    private String name;

    public TaxiFleet(String name, List<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public String getFleetName() {
        return name;
    }

    public void addCar(Car car) { cars.add(car); }
    public boolean removeCar(Car car) { return cars.remove(car);  }
    public List<Car> getCars() { return cars; }
    public String getName() { return name; }

    public String toString() {
        return " Таксопарк{" +
                "Назва='" + name + '\'' +
                ", Машини=" + cars +
                '}'+ "\n";
    }
}
