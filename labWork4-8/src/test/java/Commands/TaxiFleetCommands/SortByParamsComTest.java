package Commands.TaxiFleetCommands;

import Car.Car;
import Car.GasCar;
import Car.ElectricCar;
import TaxiFleet.TaxiFleet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortByParamsComTest {
    private TaxiFleet fleet;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        fleet = new TaxiFleet("Test Fleet", new ArrayList<>());

        // Додаємо кілька тестових автомобілів
        fleet.addCar(new GasCar("Toyota", "Corolla", 20000, 180, 6.5));
        fleet.addCar(new ElectricCar("Tesla", "Model 3", 35000, 200, 15));
        fleet.addCar(new GasCar("Honda", "Civic", 22000, 190, 7.0));
        fleet.addCar(new ElectricCar("Nissan", "Leaf", 25000, 150, 12));

        // Підключаємо ByteArrayOutputStream для перехоплення виводу
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testSortByPrice() {
        // Створюємо команду для сортування
        SortByParamsCom command = new SortByParamsCom(fleet);

        // Введення для вибору критерію сортування за ціною (1)
        System.setIn(new java.io.ByteArrayInputStream("1\n".getBytes())); // Вибір 1 для ціни
        command.execute();

        // Перевіряємо, чи автомобілі відсортовані за ціною
        List<Car> cars = command.getListCars();
        assertTrue(cars.get(0).getPrice() <= cars.get(1).getPrice(), "Автомобілі не відсортовані за ціною.");
        assertTrue(cars.get(1).getPrice() <= cars.get(2).getPrice(), "Автомобілі не відсортовані за ціною.");
        assertTrue(cars.get(2).getPrice() <= cars.get(3).getPrice(), "Автомобілі не відсортовані за ціною.");
    }

    @Test
    void testSortByConsumption() {
        // Створюємо команду для сортування
        SortByParamsCom command = new SortByParamsCom(fleet);

        // Введення для вибору критерію сортування за споживанням (2)
        System.setIn(new java.io.ByteArrayInputStream("2\n".getBytes())); // Вибір 2 для споживання
        command.execute();

        // Перевіряємо, чи бензинові машини відсортовані за споживанням
        List<Car> cars = command.getListCars();
        assertTrue(cars.get(0).getConsumption() <= cars.get(1).getConsumption(), "Бензинові машини не відсортовані за споживанням.");
        //assertTrue(cars.get(1).getConsumption() >= cars.get(2).getConsumption(), "Бензинові машини не відсортовані за споживанням.");
        assertTrue(cars.get(2).getConsumption() <= cars.get(3).getConsumption(), "Електричні машини не відсортовані за споживанням.");
    }

    @Test
    void testSortByMaxSpeed() {
        // Створюємо команду для сортування
        SortByParamsCom command = new SortByParamsCom(fleet);

        // Введення для вибору критерію сортування за максимальною швидкістю (3)
        System.setIn(new java.io.ByteArrayInputStream("3\n".getBytes())); // Вибір 3 для швидкості
        command.execute();

        // Перевіряємо, чи автомобілі відсортовані за максимальною швидкістю
        List<Car> cars = command.getListCars();
        assertTrue(cars.get(0).getMaxSpeed() <= cars.get(1).getMaxSpeed(), "Автомобілі не відсортовані за максимальною швидкістю.");
        assertTrue(cars.get(1).getMaxSpeed() <= cars.get(2).getMaxSpeed(), "Автомобілі не відсортовані за максимальною швидкістю.");
        assertTrue(cars.get(2).getMaxSpeed() <= cars.get(3).getMaxSpeed(), "Автомобілі не відсортовані за максимальною швидкістю.");
    }

    @Test
    void testEmptyFleet() {
        // Створюємо новий порожній автопарк
        TaxiFleet emptyFleet = new TaxiFleet("Test Fleet", new ArrayList<>());
        SortByParamsCom command = new SortByParamsCom(emptyFleet);

        // Введення для вибору критерію сортування за ціною (1)
        System.setIn(new java.io.ByteArrayInputStream("1\n".getBytes())); // Вибір 1 для ціни
        command.execute();

        // Перевіряємо, чи виводиться повідомлення про порожній автопарк
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Список автомобілів порожній"), "Повідомлення про порожній автопарк не з'явилось.");
    }
}
