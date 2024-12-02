package Commands.MenuCommands;

import TaxiFleet.TaxiFleet;
import Commands.Command;
import Car.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManageTFleetComTest {

    @Test
    void testExecuteWithEmptyFleetList() {
        // Підготовка: порожній список таксопарків
        List<TaxiFleet> fleets = new ArrayList<>();
        ManageTFleetCom manageCommand = new ManageTFleetCom(fleets);

        // Захоплення виводу
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Виконання
        manageCommand.execute();

        // Очікуваний результат
        String expectedOutput = "Список порожній. Для початку створіть таксопарк. \n";

        // Перевірка
        assertEquals(expectedOutput, outContent.toString().replace("\r", ""));
    }

    @Test
    void testExecuteWithValidFleetSelection() {
        // Підготовка: створення таксопарків
        List<TaxiFleet> fleets = new ArrayList<>();
        TaxiFleet fleet1 = new TaxiFleet("Urban Fleet", new ArrayList<>());
        fleets.add(fleet1);

        ManageTFleetCom manageCommand = new ManageTFleetCom(fleets);

        // Вхідні дані: вибір таксопарку і вихід
        String userInput = "1\n7\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inContent);

        // Захоплення виводу
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Виконання
        manageCommand.execute();

        // Очікуваний результат (частина виводу для вибору таксопарку)
        String expectedOutputContains =
                "--------Управлiння Таксопарком--------\r\n" +
                        "1. Додати автомобіль\r\n" +
                        "2. Видалити автомобіль\r\n" +
                        "3. Розрахувати загальну вартiсть\r\n" +
                        "4. Відсортувати автомобілі\r\n" +
                        "5. Знайти автомобілі за параметрами\r\n" +
                        "6. Показати всi автомобілі\r\n" +
                        "7. Повернутися назад\r\n" +
                        "Вибiр: \r\n";

        // Перевірка (переконатися, що очікуваний фрагмент присутній у виводі)
        assertTrue(outContent.toString().contains(expectedOutputContains));
    }

    @Test
    void testExecuteWithInvalidFleetSelection() {
        // Підготовка: створення таксопарків
        List<TaxiFleet> fleets = new ArrayList<>();
        TaxiFleet fleet1 = new TaxiFleet("Urban Fleet", new ArrayList<>());
        fleets.add(fleet1);

        ManageTFleetCom manageCommand = new ManageTFleetCom(fleets);

        // Вхідні дані: неправильний вибір таксопарку
        String userInput = "2\n7\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inContent);

        // Захоплення виводу
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Виконання
        manageCommand.execute();

        // Очікуваний результат
        String expectedOutputContains = "Неправильний вибiр.\r\n";

        // Перевірка
        assertTrue(outContent.toString().contains(expectedOutputContains));
    }
}
