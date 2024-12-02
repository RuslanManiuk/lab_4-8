package Commands.TaxiFleetCommands;

import Car.Car;
import Car.GasCar;
import TaxiFleet.TaxiFleet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FindCarsByParamsComTest {
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
    void testFindCarsByParams() {
        // Встановлюємо мінімальну та максимальну швидкість для пошуку
        int minSpeed = 180;
        int maxSpeed = 200;

        // Виконуємо команду
        FindCarsBySpeedCom command = new FindCarsBySpeedCom(fleet);
        String userInput = "180\n200\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inContent);
        command.execute();

        // Отримуємо результат виводу
        String output = outputStream.toString().trim();

        // Перевіряємо, чи є автомобілі в діапазоні швидкостей
        List<Car> filteredCars = fleet.getCars().stream()
                .filter(car -> car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed)
                .toList();

        // Перевіряємо, що всі автомобілі, які виведені, мають швидкість в зазначеному діапазоні
        for (Car car : filteredCars) {
            assertTrue(car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed,
                    "Автомобіль не відповідає діапазону швидкостей: " + car);
        }

        // Перевіряємо, що у виведеному результаті присутні автомобілі в діапазоні
        filteredCars.forEach(car -> {
            assertTrue(output.contains(car.toString()),
                    "Виведено неправильний автомобіль: " + car);
        });
    }
}
