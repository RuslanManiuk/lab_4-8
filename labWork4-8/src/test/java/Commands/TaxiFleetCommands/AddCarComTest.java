package Commands.TaxiFleetCommands;

import TaxiFleet.TaxiFleet;
import Car.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AddCarComTest {

    @Test
    void testAddGasCar() {
        // Підготовка: створення таксопарку
        TaxiFleet fleet = new TaxiFleet("Test Fleet", new ArrayList<>());
        AddCarCom addCarCommand = new AddCarCom(fleet);

        // Вхідні дані: параметри бензинової машини
        String userInput = "Toyota\nCorolla\n25000\n200\n1\n7,5\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inContent);

        // Захоплення виводу
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Виконання
        addCarCommand.execute();

        // Перевірка, що автомобіль додано до таксопарку
        assertEquals(1, fleet.getCars().size());
        assertTrue(fleet.getCars().get(0) instanceof GasCar);

        // Перевірка параметрів автомобіля
        GasCar car = (GasCar) fleet.getCars().get(0);
        assertTrue(car.toString().contains("Toyota"));
        assertEquals(25000, car.getPrice());
        assertEquals(200, car.getMaxSpeed());
        assertEquals(7.5, car.getConsumption());
    }

    @Test
    void testAddElectricCar() {
        // Підготовка: створення таксопарку
        TaxiFleet fleet = new TaxiFleet("Test Fleet", new ArrayList<>());
        AddCarCom addCarCommand = new AddCarCom(fleet);

        // Вхідні дані: параметри електромобіля
        String userInput = "Tesla\nModel S\n80000\n250\n2\n85\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inContent);

        // Захоплення виводу
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Виконання
        addCarCommand.execute();

        // Перевірка, що автомобіль додано до таксопарку
        assertEquals(1, fleet.getCars().size());
        assertTrue(fleet.getCars().get(0) instanceof ElectricCar);

        // Перевірка параметрів автомобіля
        ElectricCar car = (ElectricCar) fleet.getCars().get(0);
        assertTrue(car.toString().contains("Tesla"));
        assertEquals(80000, car.getPrice());
        assertEquals(250, car.getMaxSpeed());
        assertEquals(85, car.getConsumption());
    }
}
