package Car;

public class GasCar extends Car {
    private double fuelConsumption;

    public GasCar(String brand, String model, double price, int maxSpeed, double fuelConsumption) {
        super(brand, model, price, maxSpeed);
        this.fuelConsumption = fuelConsumption;
    }

    public double getConsumption() { return fuelConsumption; }
    public String getType(){ return "Gas"; }

    public String toString(){
        return super.toString() + "Витрата палива: " + fuelConsumption + "л/100км";
    }
}
