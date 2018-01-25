package by.tc.task01.main.outputToConsole;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;

public class VacuumCleanerPrinter implements OutputCommand {
    public String printApplianceParameters(Appliance appliance){

        VacuumCleaner vacuumCleaner = (VacuumCleaner) appliance;

        return "VacuumCleaner : POWER_CONSUMPTION=" + vacuumCleaner.getPowerConsumption() +
                ", FILTER_TYPE=" + vacuumCleaner.getFilterType() +
                ", BAG_TYPE=" + vacuumCleaner.getBagType() +
                ", WAND_TYPE=" + vacuumCleaner.getWandType() +
                ", MOTOR_SPEED_REGULATION=" + vacuumCleaner.getMotorSpeedRegulation() +
                ", CLEANING_WIDTH=" + vacuumCleaner.getCleaningWidth();
    }
}
