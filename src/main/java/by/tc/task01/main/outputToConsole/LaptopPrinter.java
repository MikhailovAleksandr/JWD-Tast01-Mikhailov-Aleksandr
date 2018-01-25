package by.tc.task01.main.outputToConsole;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;

public class LaptopPrinter implements OutputCommand {
    @Override
    public String printApplianceParameters(Appliance appliance){
        Laptop laptop = (Laptop) appliance;

        return "Laptop : BATTERY_CAPACITY=" + laptop.getBatteryCapacity()+
                ", OS=" + laptop.getOs() +
                ", MEMORY_ROM=" + laptop.getMemoryROM()  +
                ", SYSTEM_MEMORY=" + laptop.getSystemMemory() +
                ", CPU=" + laptop.getCPU() +
                ", DISPLAY_INCHS="+ laptop.getDisplayInchs();
    }
}
