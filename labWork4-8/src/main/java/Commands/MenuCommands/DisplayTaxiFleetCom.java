package Commands.MenuCommands;

import TaxiFleet.TaxiFleet;
import Commands.Command;

import java.util.List;

public class DisplayTaxiFleetCom implements Command {
    private List<TaxiFleet> fleets;

    public DisplayTaxiFleetCom(List<TaxiFleet> fleets) { this.fleets = fleets; }

    @Override
    public void execute() {
        if(fleets.isEmpty()) {
            System.out.println("Немає таксопарків для показу");
            return;
        }

        int i = 0;
        for(TaxiFleet fleet : fleets) {
            System.out.print(i + 1);
            System.out.println(fleet);
            System.out.println("---------------");
            i+=1;
        }
    }
}
