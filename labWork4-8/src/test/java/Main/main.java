package Main;

import main.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final ByteArrayInputStream inputStream = new ByteArrayInputStream("0\n".getBytes());
    private final PrintStream originalOut = System.out;
    private final ByteArrayInputStream originalIn = (ByteArrayInputStream) System.in;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outputStream)); // Перенаправлення виводу в ByteArrayOutputStream
        System.setIn(inputStream); // Перенаправлення вводу в ByteArrayInputStream
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut); // Відновлення оригінального потоку виводу
        System.setIn(originalIn); // Відновлення оригінального потоку вводу
    }

    @Test
    void testMain() {
        // Викликаємо main метод класу Main
        Main.main(new String[]{});

        // Перевіряємо, чи виведено привітальне повідомлення
        String output = outputStream.toString();
        assertTrue(output.contains("Вітаємо в Системі управлiння таксопарком!"));
        assertTrue(output.contains("До побачення!"));
    }

    @Test
    void testInvalidChoice() {
        // Симулюємо неправильний ввід, потім правильний для виходу
        String input = "99\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Викликаємо main метод класу Main
        Main.main(new String[]{});

        // Перевіряємо, що помилка введення була виведена
        String output = outputStream.toString();
        assertTrue(output.contains("Некоректний вибір!"));
    }
}
