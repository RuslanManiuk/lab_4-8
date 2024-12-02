package Interface;

import Interface.UserInterface;
import TaxiFleet.TaxiFleet;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1024 * 1024);
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testStartAndExit() {
        // Simulate user input: 0 (exit)
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        UserInterface ui = new UserInterface();
        ui.start();

        // Assert expected output
        String output = outputStream.toString();
        assertTrue(output.contains("Вітаємо в Системі управлiння таксопарком!"));
        assertTrue(output.contains("До побачення!"));
    }

    @Test
    void testInvalidMenuChoice() {
        // Simulate invalid input: 99 (invalid option), then exit: 0
        String input = "99\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        UserInterface ui = new UserInterface();
        ui.start();

        // Assert expected output
        String output = outputStream.toString();
        assertTrue(output.contains("Некоректний вибір!"));
        assertTrue(output.contains("До побачення!"));
    }

    @Test
    void testCreateFleet() {
        // Симулюємо введення: 1 (створення таксопарку), "My Fleet" (назва таксопарку), 0 (вихід)
        String input = "1\nMy Fleet\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        UserInterface ui = new UserInterface();
        ui.start();

        // Перевіряємо, чи створено таксопарк
        List<TaxiFleet> fleets = ui.getUserFleets(); // Якщо є геттер до userFleets
        assertEquals(1, fleets.size(), "Таксопарк не було створено.");
        assertEquals("My Fleet", fleets.getFirst().getName(), "Назва створеного таксопарку неправильна.");
    }

}
