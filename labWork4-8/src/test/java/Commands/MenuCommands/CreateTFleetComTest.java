package Commands.MenuCommands;

import TaxiFleet.TaxiFleet;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CreateTFleetComTest {

    @Test
    void testExecuteCreatesNewFleet() {
        // Підготовка: список таксопарків і тестові дані
        List<TaxiFleet> fleets = new ArrayList<>();
        String userInput = "Urban Fleet\n"; // Введення користувача
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        Scanner scanner = new Scanner(in); // Створення Scanner з потоку ByteArrayInputStream

        // Команда створення таксопарку
        CreateTFleetCom createFleetCommand = new CreateTFleetCom(fleets, scanner);

        // Виконання команди
        createFleetCommand.execute();

        // Перевірка результату
        assertEquals(1, fleets.size(), "Таксопарк не створено.");
        assertEquals("Urban Fleet", fleets.get(0).getName(), "Назва таксопарку неправильна.");
        assertTrue(fleets.get(0).getCars().isEmpty(), "Список автомобілів має бути порожнім.");
    }

}
