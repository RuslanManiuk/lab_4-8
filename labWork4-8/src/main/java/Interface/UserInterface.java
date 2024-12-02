package Interface;

import TaxiFleet.TaxiFleet;

import Commands.Command;
import Commands.MenuCommands.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class UserInterface {
    private static Logger logger = LoggerFactory.getLogger(Command.class);

    private List<TaxiFleet> userFleets;
    private Scanner scanner;
    private Map<Integer, Command> menuCommands;

    public UserInterface() {
        userFleets = new ArrayList<>();
        scanner = new Scanner(System.in);
        menuCommands = new HashMap<>();

        menuCommands.put(1, new CreateTFleetCom(this.userFleets, scanner));
        menuCommands.put(2, new ManageTFleetCom(this.userFleets));
        menuCommands.put(3, new DisplayTaxiFleetCom(this.userFleets));
    }

    public void start() {
        System.out.println("\n-------------------------------------------");
        System.out.println("Вітаємо в Системі управлiння таксопарком!");
        System.out.println("-------------------------------------------");

        logger.info("Початок програми");
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--------------Головне меню-----------------");
            System.out.println("1. Створити новий таксопарк");
            System.out.println("2. Керувати таксопарком");
            System.out.println("3. Показати всi таксопарки");
            System.out.println("0. Вихiд");

            System.out.print("Вибiр опції:");
            System.out.println();
            try {
                logger.info("Перед вибором");
                int choice = scanner.nextInt();
                scanner.nextLine();
                logger.info("Вибір: " + choice);

                if (choice == 0) {
                    exit = true;
                    logger.info("Користувач завершив роботу.");
                } else if (menuCommands.containsKey(choice)) {
                    menuCommands.get(choice).execute();
                } else {
                   System.out.println("Некоректний вибір!");
                   logger.warn("Користувач ввів неправильний вибір: " + choice);
                }
            } catch (Exception e) {
                System.out.println("Помилка введення, спробуйте ще раз.");
                logger.error("Помилка введення", e);
            }
        }

        System.out.println("До побачення!");
    }

    public List<TaxiFleet> getUserFleets() { return userFleets; }

    public void closeScanner() {
        if(scanner != null) {
            scanner.close();
        }
    }
}
