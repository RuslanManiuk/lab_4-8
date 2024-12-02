package Commands.MenuCommands;

import TaxiFleet.TaxiFleet;
import Commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateTFleetCom implements Command {
    private List<TaxiFleet> fleets;
    private Scanner scanner;

    public CreateTFleetCom(List<TaxiFleet> fleets, Scanner scanner) {
        this.fleets = fleets;
        this.scanner = scanner;
    }

    @Override
    public void execute(){

        System.out.print("Введіть назву таксопарку: ");
        //Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

//        if (name == null || name.trim().isEmpty()) {
//            System.out.println("Назва таксопарку не може бути порожньою.");
//            return;
//        }
//
//        for (TaxiFleet fleet : fleets) {
//            if (fleet.getName().equals(name)) {
//                System.out.println("Таксопарк із такою назвою вже існує.");
//                return;
//            }
//        }

        TaxiFleet newTaxiFleet = new TaxiFleet(name, new ArrayList<>());

        fleets.add(newTaxiFleet);
        System.out.println("Новий таксопарк створено.");
    }
}
