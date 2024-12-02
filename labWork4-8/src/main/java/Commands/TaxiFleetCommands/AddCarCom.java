package Commands.TaxiFleetCommands;

import TaxiFleet.TaxiFleet;
import Car.*;
import Commands.Command;

import java.util.Scanner;

public class AddCarCom implements Command {
    private TaxiFleet fleet;

    public AddCarCom(TaxiFleet fleet) {this.fleet = fleet;}

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n------Додати нову машину-------");
        System.out.print("Введіть марку автомобіля: ");
        String brand = input.nextLine();
        logger.info("Додано марку: " + brand);

        System.out.print("Введіть модель автомобіля: ");
        String model = input.nextLine();
        logger.info("Додано модель: " + model);

        System.out.print("Введіть ціну автомобіля: ");
        double price = input.nextDouble();
        logger.info("Додано ціну: " + price);

        System.out.print("Введіть максимальну швидкість: ");
        int maxSpeed = input.nextInt();
        input.nextLine(); // очистка буфера
        logger.info("Додано макс. швидкість: " + maxSpeed);

        System.out.println("Введіть тип машини(1 - Бензин/Дизель, 2 - Електрична)");
        int carType = input.nextInt();
        input.nextLine();
        logger.info("Додано тип автомобіля: " + carType);

        Car newCar = null;
        while(newCar == null){
            switch(carType){
                case 1 -> {
                    System.out.print("Введіть витрату палива(л/100км): ");
                    double fuelConsumption = input.nextDouble();
                    newCar = new GasCar(brand, model, price, maxSpeed, fuelConsumption);
                    logger.info("Додано витрату палива: " + fuelConsumption);
                }
                case 2 -> {
                    System.out.print("Введіть ємність батареї(кВт*год/100км)): ");
                    double batteryCapacity = input.nextDouble();
                    newCar = new ElectricCar(brand, model, price, maxSpeed, batteryCapacity);
                    logger.info("Додано ємність батареї: " + batteryCapacity);
                }
                default -> System.out.println("Некоректний вибір. Спробуйте ще раз");
            }
        }

        fleet.addCar(newCar);
        System.out.println("Автомобіль додано до таксопарку.");
        logger.info("Додано новий автомобіль: " + newCar);
    }
}
