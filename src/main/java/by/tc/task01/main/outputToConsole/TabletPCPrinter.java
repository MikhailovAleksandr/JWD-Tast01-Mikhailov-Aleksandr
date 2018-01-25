package by.tc.task01.main.outputToConsole;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;

public class TabletPCPrinter implements OutputCommand {
    public String printApplianceParameters(Appliance appliance){

        TabletPC tabletPC = (TabletPC) appliance;

        return "TabletPC : BATTERY_CAPACITY=" + tabletPC.getBattaryCapacity() +
                ", DISPLAY_INCHES=" + tabletPC.getDisplayInches() +
                ", MEMORY_ROM=" + tabletPC.getMemoryROM() +
                ", FLASH_MEMORY_CAPACITY=" + tabletPC.getFlashMemoryCapacity() +
                ", COLOR=" + tabletPC.getColor();
    }
}
