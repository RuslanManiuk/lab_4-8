package Commands.TaxiFleetCommands;

import Commands.Command;
import TaxiFleet.TaxiFleet;
import Car.Car;

import java.util.List;

public class CalculateTotalValueTFCom implements Command {
    private TaxiFleet fleet;

    public CalculateTotalValueTFCom(TaxiFleet fleet) { this.fleet = fleet; }

    @Override
    public void execute() {
        List<Car> cars = fleet.getCars();
        double totalValue = 0;

        for (Car car : cars) {
            totalValue += car.getPrice();
        }
        System.out.printf("Загальна вартість автопарку: %.2f%n", totalValue);
        logger.info("Загльна вартість таксопарку: " + totalValue);
    }
}
