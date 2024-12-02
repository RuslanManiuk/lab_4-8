package Car;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ElectricCarTest {

    @Test
    void testElectricCarAttributes() {
        // Створення екземпляра ElectricCar
        ElectricCar electricCar = new ElectricCar("Tesla", "Model S", 79999.99, 250, 100);

        // Перевірка значень атрибутів
        assertEquals(79999.99, electricCar.getPrice(), 0.01);
        assertEquals(250, electricCar.getMaxSpeed());
        assertEquals(100, electricCar.getConsumption(), 0.01);
        assertEquals("Electric", electricCar.getType());
    }

    @Test
    void testToString() {
        // Створення екземпляра ElectricCar
        ElectricCar electricCar = new ElectricCar("Nissan", "Leaf", 35000, 150, 40);

        // Очікуваний результат
        String expected = "Марка: Nissan Модель: Leaf Ціна: $35000.0 макс. швидкість: 150км/годЄмність батареї: 40.0кВт";

        // Перевірка методу toString
        assertEquals(expected, electricCar.toString());
    }
}
