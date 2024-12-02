package Commands.TaxiFleetCommands;

import Car.Car;
import Car.GasCar;
import TaxiFleet.TaxiFleet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoveCarComTest {
    private TaxiFleet fleet;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        fleet = new TaxiFleet("Test Fleet", new ArrayList<>());

        // Додаємо кілька тестових автомобілів
        fleet.addCar(new GasCar("Toyota", "Corolla", 20000, 180, 6.5));
        fleet.addCar(new GasCar("Honda", "Civic", 22000, 200, 7.0));
        fleet.addCar(new GasCar("Ford", "Focus", 18000, 190, 5.8));

        // Підключаємо ByteArrayOutputStream для перехоплення виводу
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testRemoveCar() {
        // Створюємо команду для видалення автомобіля
        RemoveCarCom command = new RemoveCarCom(fleet);

        // Перевіряємо, чи є всі автомобілі в автопарку до видалення
        List<Car> carsBefore = fleet.getCars();
        assertEquals(3, carsBefore.size(), "Кількість автомобілів перед видаленням має бути 3");

        // Виконуємо команду для видалення (потрібно вибрати індекс, наприклад, 2 для "Honda")
        System.setIn(new java.io.ByteArrayInputStream("2\n".getBytes())); // Введення для індексу 2
        command.execute();

        // Перевіряємо, чи автомобіль був видалений з автопарку
        List<Car> carsAfter = fleet.getCars();
        assertEquals(2, carsAfter.size(), "Кількість автомобілів після видалення має бути 2");

        // Перевіряємо, чи "Honda" був видалений
        assertFalse(carsAfter.stream().anyMatch(car -> car.getModel().equals("Civic")),
                "Автомобіль Honda Civic має бути видалений.");

        // Перевіряємо, чи у виводі міститься повідомлення про видалення
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Автомобіль видалено"), "Повідомлення про видалення не з'явилось.");
    }
}
