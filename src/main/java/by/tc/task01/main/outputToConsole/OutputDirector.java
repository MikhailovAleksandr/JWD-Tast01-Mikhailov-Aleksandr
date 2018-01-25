package by.tc.task01.main.outputToConsole;

import java.util.HashMap;
import java.util.Map;

public class OutputDirector {
    public Map<String, OutputCommand> map = new HashMap<String, OutputCommand>();

    public OutputDirector(){

        map.put("Laptop",new LaptopPrinter());
        map.put("Oven",new OvenPrinter());
        map.put("Refrigerator",new RefrigeratorPrinter());
        map.put("Speakers", new SpeakersPrinter());
        map.put("TabletPC", new TabletPCPrinter());
        map.put("VacuumCleaner", new VacuumCleanerPrinter());
    }

    public OutputCommand getOutputCommand(String applienceType){

        OutputCommand outputCommand;

        outputCommand = map.get(applienceType);

        return outputCommand;
    }
}
