package Commands.MenuCommands;

import TaxiFleet.TaxiFleet;
import Car.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTaxiFleetComTest {

    @Test
    void testExecuteNoFleets() {
        // Підготовка: порожній список таксопарків
        List<TaxiFleet> fleets = new ArrayList<>();
        DisplayTaxiFleetCom displayCommand = new DisplayTaxiFleetCom(fleets);

        // Захоплення виводу у консоль
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Виконання команди
        displayCommand.execute();

        // Очікуваний результат
        String expectedOutput = "Немає таксопарків для показу\n";

        // Перевірка
        assertEquals(expectedOutput, outContent.toString().replace("\r", ""));
    }

    @Test
    void testExecuteWithFleets() {
        // Підготовка: створення кількох таксопарків
        List<TaxiFleet> fleets = new ArrayList<>();
        TaxiFleet fleet1 = new TaxiFleet("Urban Fleet", new ArrayList<>());
        TaxiFleet fleet2 = new TaxiFleet("Luxury Fleet", new ArrayList<>());
        fleets.add(fleet1);
        fleets.add(fleet2);

        DisplayTaxiFleetCom displayCommand = new DisplayTaxiFleetCom(fleets);

        // Захоплення виводу у консоль
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Виконання команди
        displayCommand.execute();

        // Очікуваний результат
        String expectedOutput =
                "1 Таксопарк{Назва='Urban Fleet', Машини=[]}\n\n" +
                        "---------------\n" +
                        "2 Таксопарк{Назва='Luxury Fleet', Машини=[]}\n\n" +
                        "---------------\n";

        // Перевірка
        assertEquals(expectedOutput, outContent.toString().replace("\r", ""));
    }
}
