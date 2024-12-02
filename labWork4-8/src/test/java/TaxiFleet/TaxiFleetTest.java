package TaxiFleet;

import Car.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class TaxiFleetTest {

    @Test
    void testTaxiFleetAttributes() {
        // Створення списку автомобілів
        List<Car> initialCars = new ArrayList<>();
        initialCars.add(new ElectricCar("Tesla", "Model 3", 45000, 200, 75));
        initialCars.add(new GasCar("Toyota", "Corolla", 20000, 180, 7.0));

        // Створення таксопарку
        TaxiFleet taxiFleet = new TaxiFleet("Green Fleet", initialCars);

        // Перевірка назви таксопарку
        assertEquals("Green Fleet", taxiFleet.getFleetName());

        // Перевірка початкового списку автомобілів
        assertEquals(2, taxiFleet.getCars().size());
    }

    @Test
    void testAddCar() {
        // Створення таксопарку
        TaxiFleet taxiFleet = new TaxiFleet("Eco Fleet", new ArrayList<>());

        // Додавання автомобіля
        Car electricCar = new ElectricCar("Nissan", "Leaf", 30000, 150, 40);
        taxiFleet.addCar(electricCar);

        // Перевірка, чи додався автомобіль
        assertEquals(1, taxiFleet.getCars().size());
        assertTrue(taxiFleet.getCars().contains(electricCar));
    }

    @Test
    void testRemoveCar() {
        // Створення таксопарку
        List<Car> cars = new ArrayList<>();
        Car gasCar = new GasCar("Ford", "Focus", 20000, 180, 6.5);
        cars.add(gasCar);

        TaxiFleet taxiFleet = new TaxiFleet("Urban Fleet", cars);

        // Видалення автомобіля
        boolean removed = taxiFleet.removeCar(gasCar);

        // Перевірка видалення
        assertTrue(removed);
        assertEquals(0, taxiFleet.getCars().size());
    }

    @Test
    void testToString() {
        // Створення списку автомобілів
        List<Car> cars = new ArrayList<>();
        cars.add(new ElectricCar("Tesla", "Model S", 79999.99, 250, 100));

        // Створення таксопарку
        TaxiFleet taxiFleet = new TaxiFleet("Luxury Fleet", cars);

        // Очікуваний результат
        String expected = "Таксопарк{Назва='Luxury Fleet', Машини=[" +
                "Марка: Tesla Модель: Model S Ціна: $79999.99 макс. швидкість: 250км/годЄмність батареї: 100.0кВт" +
                "]}";

        // Перевірка методу toString
        assertEquals(expected, taxiFleet.toString().trim());
    }
}
