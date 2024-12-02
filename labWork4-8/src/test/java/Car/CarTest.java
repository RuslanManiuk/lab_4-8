package Car;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    // Створення тестового підкласу
    static class TestCar extends Car {
        private double consumption;

        public TestCar(String brand, String model, double price, int maxSpeed, double consumption) {
            super(brand, model, price, maxSpeed);
            this.consumption = consumption;
        }

        @Override
        public double getConsumption() {
            return consumption;
        }

        @Override
        public String getType() {
            return "TestCar";
        }
    }

    @Test
    void testCarAttributes() {
        Car car = new TestCar("Toyota", "Corolla", 20000, 180, 6.5);

        // Тестування атрибутів
        assertEquals(20000, car.getPrice(), 0.01);
        assertEquals(180, car.getMaxSpeed());
        assertEquals(6.5, car.getConsumption(), 0.01);
        assertEquals("TestCar", car.getType());
    }

    @Test
    void testToString() {
        Car car = new TestCar("Honda", "Civic", 22000, 200, 7.0);

        // Очікуваний результат
        String expected = "Марка: Honda Модель: Civic Ціна: $22000.0 макс. швидкість: 200км/год";

        // Тестування методу toString
        assertEquals(expected, car.toString());
    }
}
