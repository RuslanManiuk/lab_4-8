package Car;

public class ElectricCar extends Car {
    private double batteryCapacity;

    public ElectricCar(String brand, String model, double price, int maxSpeed, double batteryCapacity) {
        super(brand, model, price, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public double getConsumption() { return batteryCapacity; }
    public String getType(){ return "Electric"; }

    public String toString(){
        return super.toString() + "Ємність батареї: " + batteryCapacity + "кВт";
    }
}
