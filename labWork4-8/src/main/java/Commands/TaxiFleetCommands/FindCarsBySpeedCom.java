package Commands.TaxiFleetCommands;

import Commands.Command;
import TaxiFleet.TaxiFleet;

import java.util.Scanner;

public class FindCarsBySpeedCom implements Command {
    private TaxiFleet fleet;

    public FindCarsBySpeedCom(TaxiFleet fleet) { this.fleet = fleet; }

    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть мінімальну швидкість: ");
        int minSpeed = scanner.nextInt();
        System.out.print("Введіть максимальну швидкість: ");
        int maxSpeed = scanner.nextInt();
        System.out.println("Автомобілі в заданому діапазоні швидкостей:");

        fleet.getCars().stream().
                filter(car -> car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed)
                .forEach(System.out::println);

        long count = fleet.getCars().stream()
                .filter(car -> car.getMaxSpeed() >= minSpeed && car.getMaxSpeed() <= maxSpeed)
                .count();
        logger.info("Кількість знайдених автомобілів: " + count);

    }
}
