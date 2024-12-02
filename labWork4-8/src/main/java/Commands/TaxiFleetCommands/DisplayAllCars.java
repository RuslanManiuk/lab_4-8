package Commands.TaxiFleetCommands;

import TaxiFleet.TaxiFleet;
import Car.Car;
import Commands.Command;

import java.util.List;

public class DisplayAllCars implements Command {
    TaxiFleet fleet;

    public DisplayAllCars(TaxiFleet fleet) { this.fleet = fleet; }

    @Override
    public void execute() {
        List<Car> cars = fleet.getCars();
        for (int i = 0; i < cars.size(); i++) {
            System.out.println((i + 1) + ". " + cars.get(i));
            System.out.println("--------------------------------------");
        }
    }
}
