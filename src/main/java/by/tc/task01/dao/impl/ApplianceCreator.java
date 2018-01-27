package by.tc.task01.dao.impl;

import by.tc.task01.dao.impl.choice.ApplianceDirector;
import by.tc.task01.dao.impl.choice.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;
import java.util.Map;


public class ApplianceCreator {

    static private ApplianceDirector director = new ApplianceDirector();


    public static <E> Appliance create(List<Object> fileLineMeanings, String applianceType){
        Command command = director.getCommand(applianceType);

         Appliance appliance = command.execute(fileLineMeanings.toArray());

        return appliance;
    }




}
