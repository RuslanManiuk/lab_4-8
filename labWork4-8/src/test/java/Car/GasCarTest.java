package Car;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GasCarTest {

    @Test
    void testGasCarAttributes() {
        // Створення екземпляра GasCar
        GasCar gasCar = new GasCar("Toyota", "Camry", 30000, 220, 8.5);

        // Перевірка значень атрибутів
        assertEquals(30000, gasCar.getPrice(), 0.01);
        assertEquals(220, gasCar.getMaxSpeed());
        assertEquals(8.5, gasCar.getConsumption(), 0.01);
        assertEquals("Gas", gasCar.getType());
    }

    @Test
    void testToString() {
        // Створення екземпляра GasCar
        GasCar gasCar = new GasCar("Ford", "Focus", 20000, 200, 6.8);

        // Очікуваний результат
        String expected = "Марка: Ford Модель: Focus Ціна: $20000.0 макс. швидкість: 200км/годВитрата палива: 6.8л/100км";

        // Перевірка методу toString
        assertEquals(expected, gasCar.toString());
    }
}
