package by.tc.task01.main;

import by.tc.task01.entity.Appliance;
import by.tc.task01.main.outputToConsole.OutputCommand;
import by.tc.task01.main.outputToConsole.OutputDirector;

public class PrintApplianceInfo {

	private static OutputDirector outputDirector;

	static{
		outputDirector =  new OutputDirector();
	}
	
	public static void print(Appliance appliance) {


		if (appliance != null) {

			String[] applianceFullName = appliance.getClass().getName().split("\\W");
			String applianceType = applianceFullName[applianceFullName.length - 1];

			OutputCommand outputCommand = outputDirector.getOutputCommand(applianceType);
			System.out.println(outputCommand.printApplianceParameters(appliance));

		}
		else if(appliance == null){
			System.out.println("null");
		}
	}
	
	// you may add your own code here

}
