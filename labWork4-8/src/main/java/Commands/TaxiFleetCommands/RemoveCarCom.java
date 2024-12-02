package Commands.TaxiFleetCommands;

import TaxiFleet.TaxiFleet;
import Car.*;
import Commands.Command;

import java.util.List;
import java.util.Scanner;

public class RemoveCarCom implements Command {
    TaxiFleet fleet;
    public RemoveCarCom(TaxiFleet fleet) { this.fleet = fleet; }

    @Override
    public void execute() {
        List<Car> cars = fleet.getCars();
        cars.forEach(System.out::println);

        System.out.print("Введіть індекс автомобіля для видалення: ");
        Scanner scanner = new Scanner(System.in);

        int index = scanner.nextInt();
        logger.info("Видалення авто: " + cars.get(index));

        fleet.removeCar(cars.get(index - 1));
        System.out.println("Автомобіль видалено.");
        logger.info("Автомобіль видалено");
    }
}
