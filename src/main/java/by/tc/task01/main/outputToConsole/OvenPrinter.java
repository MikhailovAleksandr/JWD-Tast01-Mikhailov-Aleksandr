package by.tc.task01.main.outputToConsole;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;

public class OvenPrinter implements OutputCommand {
    public String printApplianceParameters(Appliance appliance){

        Oven oven = (Oven) appliance;
        return "Oven : POWER_CONSUMPTION=" + oven.getPowerConsumption() +
                ", WEIGHT=" + oven.getWeight() +
                ", CAPACITY=" + oven.getCapacity() +
                ", DEPTH=" + oven.getDepth() +
                ", HEIGHT=" + oven.getHeight() +
                ", WIDTH=" + oven.getWidth();

    }
}
