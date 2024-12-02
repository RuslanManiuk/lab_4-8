package Commands.TaxiFleetCommands;

import TaxiFleet.TaxiFleet;
import Car.*;
import Commands.Command;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortByParamsCom implements Command {
    private TaxiFleet fleet;
    private List<Car> cars;

    public SortByParamsCom(TaxiFleet fleet) {
        this.fleet = fleet;
    }

    @Override
    public void execute() {
        List<Car> originalCars = fleet.getCars();

        if(originalCars.isEmpty()){
            System.out.println("Список автомобілів порожній.");
            return;
        }

        // працюємо з копією списку
        cars = new ArrayList<>(originalCars);

        System.out.println("\nСортувати за критерієм:");
        System.out.println("1. Ціна");
        System.out.println("2. Споживання ресурсів");
        System.out.println("3. Максимальна швидкість");

        Scanner scanner = new Scanner(System.in);
        int criterion = scanner.nextInt();

        Comparator<Car> comparator;

        switch (criterion) {
            case 1 -> {
                comparator = Comparator.comparingDouble(Car::getPrice);
                cars.sort(comparator);

                System.out.println("\nВідсортовані машини за ціною:");
                cars.forEach(System.out::println);
                logger.info("Машини відсортовані за ціною");
            }
            case 2 -> {
                comparator = Comparator.comparingDouble(Car::getConsumption);
                sortByConsumption(cars, comparator);
            }
            case 3 -> {
                comparator = Comparator.comparingInt(Car::getMaxSpeed);
                cars.sort(comparator);

                System.out.println("\nВідсортовані машини за максимальною швидкістю:");
                cars.forEach(System.out::println);
                logger.info("Відсортовані за максимальною швидкістю");
            }
            default -> {
                System.out.println("Некоректний вибір. Сортування не виконано.");
            }
        }
    }

    public void sortByConsumption(List<Car> cars, Comparator<Car> comparator) {
        List<Car> gasCars = new ArrayList<>();
        List<Car> electricCars = new ArrayList<>();

        for(Car car : cars) {
            if(car.getType().equals("Gas")){
                gasCars.add(car);
            } else if(car.getType().equals("Electric")){
                electricCars.add(car);
            }
        }

        gasCars.sort(comparator);
        electricCars.sort(comparator);

        System.out.println("\nВідсортовані бензинові машини:");
        gasCars.forEach(System.out::println);

        System.out.println("\nВідсортовані електричні машини:");
        electricCars.forEach(System.out::println);

        cars.addAll(gasCars);
        cars.addAll(electricCars);
    }

    public List<Car> getListCars() { return cars; }
}