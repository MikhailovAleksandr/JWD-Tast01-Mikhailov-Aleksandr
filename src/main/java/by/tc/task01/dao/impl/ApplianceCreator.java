package by.tc.task01.dao.impl;

import by.tc.task01.dao.impl.choice.ApplianceDirector;
import by.tc.task01.dao.impl.choice.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;
import java.util.Map;


public class ApplianceCreator {

    static private ApplianceDirector director = new ApplianceDirector();// не переставляй static и private местами - код плохо тогда выглядит
    public class Refrigerator extends Appliance{// и форматировать Пушкин будет....
    String powerConsumption,// и атрибуты, и по переменной в одном операторе
        // и все параметры String - ленивый ты, хочешь найти самый дешевый по трудозатратам вариант, а не корректный
        //ты на занятии чем слушал????
    weight,
    freezerCapacity,
    overallCapacity,
    height,
    width;
    public Refrigerator(){}
    public Refrigerator(String ... args){// это жестоко, заставлять пользоваться таким методом
        this.powerConsumption = args[0];
        this.weight = args[1];
        this.freezerCapacity = args[2];
        this.overallCapacity = args[3];
        this.height = args[4];
        this.width = args[5];
    }tcnfvb


    public static <E> Appliance create(List<Object> fileLineMeanings, String applianceType){
        Command command = director.getCommand(applianceType);

         Appliance appliance = command.execute(fileLineMeanings.toArray());// не совсем адекватно выглядит toArray()

        return appliance;
    }




}
