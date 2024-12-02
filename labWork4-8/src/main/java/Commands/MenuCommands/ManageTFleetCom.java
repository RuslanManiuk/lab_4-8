package Commands.MenuCommands;

import Commands.TaxiFleetCommands.*;
import TaxiFleet.TaxiFleet;
import Commands.Command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ManageTFleetCom implements Command {
    private List<TaxiFleet> fleets;

    public ManageTFleetCom(List<TaxiFleet> fleets) {
        this.fleets = fleets;
    }

    @Override
    public void execute(){
        if(this.fleets.isEmpty()) {
            System.out.println("Список порожній. Для початку створіть таксопарк. ");
            return;
        }
        DisplayTaxiFleetCom displayTaxiFleetCom = new DisplayTaxiFleetCom(this.fleets);
        displayTaxiFleetCom.execute();
        System.out.print("Виберiть таксопарк для управлiння:");
        Scanner scanner = new Scanner(System.in);
        int index =  Command.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= this.fleets.size()) {
            System.out.println("Неправильний вибiр.");
            return;
        }

        TaxiFleet selectedFleet = this.fleets.get(index);
        Map<Integer, Command> manageCommands = new HashMap<>();
        manageCommands.put(1, new AddCarCom(selectedFleet));
        manageCommands.put(2, new RemoveCarCom(selectedFleet));
        manageCommands.put(3, new CalculateTotalValueTFCom(selectedFleet));
        manageCommands.put(4, new SortByParamsCom(selectedFleet));
        manageCommands.put(5, new FindCarsBySpeedCom(selectedFleet));
        manageCommands.put(6, new DisplayAllCars(selectedFleet));

        boolean back = false;
        while (!back) {
            System.out.println("\n--------Управлiння Таксопарком--------");
            System.out.println("1. Додати автомобіль");
            System.out.println("2. Видалити автомобіль");
            System.out.println("3. Розрахувати загальну вартiсть");
            System.out.println("4. Відсортувати автомобілі");
            System.out.println("5. Знайти автомобілі за параметрами");
            System.out.println("6. Показати всi автомобілі");
            System.out.println("7. Повернутися назад");

            System.out.print("Вибiр: ");
            System.out.println();
            int choice = Command.parseInt(scanner.nextLine());
            logger.info("Вибір опції: " + choice);

            if (choice == 7) {
                back = true;
            } else if (manageCommands.containsKey(choice)) {
                manageCommands.get(choice).execute();
            } else {
                System.out.println("Неправильний вибiр, спробуйте ще раз.");
                logger.warn("Користувач ввів неправильний вибір: " + choice);
            }
        }
    }
}
