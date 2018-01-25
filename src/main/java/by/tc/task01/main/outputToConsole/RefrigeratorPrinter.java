package by.tc.task01.main.outputToConsole;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;

public class RefrigeratorPrinter implements OutputCommand {
    public String printApplianceParameters(Appliance appliance){

        Refrigerator refrigerator = (Refrigerator) appliance;

        return "Refrigerator : POWER_CONSUMPTION=" + refrigerator.getPowerConsumption() +
                ", WEIGHT=" + refrigerator.getWeight() +
                ", FREEZER_CAPACITY=" + refrigerator.getFreezerCapacity() +
                ", OVERALL_CAPACITY=" + refrigerator.getOverallCapacity() +
                ", HEIGHT=" + refrigerator.getHeight() +
                ", WIDTH=" + refrigerator.getWidth();
    }
}
