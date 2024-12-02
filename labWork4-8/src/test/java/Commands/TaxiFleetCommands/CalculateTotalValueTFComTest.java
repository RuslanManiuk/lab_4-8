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

class CalculateTotalValueTFComTest {
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
    void testCalculateTotalValue() {
        // Виконуємо команду
        CalculateTotalValueTFCom command = new CalculateTotalValueTFCom(fleet);
        command.execute();

        // Отримуємо результат виводу
        String output = outputStream.toString().trim();

        // Перевіряємо очікуваний результат
        assertEquals("Загальна вартість автопарку: 60000,00", output);
    }
}
