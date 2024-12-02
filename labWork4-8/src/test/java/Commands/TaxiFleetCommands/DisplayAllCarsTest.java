package Commands.TaxiFleetCommands;

import Car.Car;
import Car.GasCar;
import TaxiFleet.TaxiFleet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisplayAllCarsTest {
    private TaxiFleet fleet;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        fleet = new TaxiFleet("Test Fleet", new ArrayList<>());

        // Додаємо тестові автомобілі
        fleet.addCar(new GasCar("Toyota", "Corolla", 20000, 180, 6.5));
        fleet.addCar(new GasCar("Honda", "Civic", 22000, 200, 7.0));
        fleet.addCar(new GasCar("Ford", "Focus", 18000, 190, 5.8));

        // Підключаємо ByteArrayOutputStream для перехоплення виводу
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testDisplayAllCars() {
        // Виконуємо команду
        DisplayAllCars command = new DisplayAllCars(fleet);
        command.execute();

        // Отримуємо результат виводу
        String output = outputStream.toString().trim();

        // Очікуваний вивід
        String expectedOutput = "1. Марка: Toyota Модель: Corolla Ціна: $20000.0 макс. швидкість: 180км/годВитрата палива: 6.5л/100км\n" +
                "--------------------------------------\n" +
                "2. Марка: Honda Модель: Civic Ціна: $22000.0 макс. швидкість: 200км/годВитрата палива: 7.0л/100км\n" +
                "--------------------------------------\n" +
                "3. Марка: Ford Модель: Focus Ціна: $18000.0 макс. швидкість: 190км/годВитрата палива: 5.8л/100км\n" +
                "--------------------------------------";

        // Перевіряємо, що фактичний результат виводу збігається з очікуваним
        assertEquals(expectedOutput, output.replace("\r", ""));
    }
}
