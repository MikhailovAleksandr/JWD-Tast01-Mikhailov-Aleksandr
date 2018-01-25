package by.tc.task01.main.outputToConsole;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;

public class SpeakersPrinter implements OutputCommand {
    public String printApplianceParameters(Appliance appliance){

        Speakers speakers = (Speakers) appliance;

        return "Speakers : POWER_CONSUMPTION=" + speakers.getPowerConsumption() +
                ", NUMBER_OF_SPEAKERS=" + speakers.getNumberOfSpeakers() +
                ", FREQUENCY_RANGE=" + speakers.getFrequencyRange() +
                ", CORD_LENGTH=" + speakers.getCordLength();
    }
}
