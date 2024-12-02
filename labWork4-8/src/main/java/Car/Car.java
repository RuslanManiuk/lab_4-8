package Car;

public abstract class Car {
    private String brand;
    private String model;
    private double price;
    private int maxSpeed;

    public Car(String brand, String model, double price, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() { return price; }
    public int getMaxSpeed() { return maxSpeed; }

    public abstract double getConsumption();
    public abstract String getType();

    public String toString(){
        return String.format("Марка: " + brand
                + " Модель: " + model
                + " Ціна: $" + price
                + " макс. швидкість: " + maxSpeed + "км/год");
    }

    public Object getModel() {
        return model;
    }
}
