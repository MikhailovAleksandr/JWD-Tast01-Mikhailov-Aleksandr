package by.tc.task01.dao.impl;

import by.tc.task01.dao.impl.choice.ApplianceDirector;
import by.tc.task01.dao.impl.choice.Command;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplianceSearcher {

    static private ApplianceDirector director = new ApplianceDirector();


    public static <E> Appliance searcher(String line, Criteria<E> criteria, Pattern patternForSearch){
        Command command = director.getCommand(criteria.getApplianceType());
        String lineType, entityType;
        List<Object> values = new ArrayList<Object>();
        Map<Object, Object> lineMeanings = new HashMap<Object, Object>();
        boolean flag = false;
        Appliance appliance = null;

        lineType = line.split(" ")[0];
        entityType = criteria.getApplianceType();

        if (entityType.equals(lineType)) { //поиск строки по типу дженерика

            parseLine(line, patternForSearch, values, lineMeanings);
            flag = compareLineAndCriteria(lineMeanings,criteria);
        }
        if ( flag ) {	//true? -> передаем лист значений в "СОЗДАТЕЛЬ"
            appliance = command.execute(values.toArray());
        }
        return appliance;
    }

    private static void parseLine(String line, Pattern pattern, List<Object> values, Map<Object, Object> lineMeanings){
        Matcher m = pattern.matcher(line);
        values.clear();

        while (m.find()) {	// поиск всех совпадений в строке
            line = m.group();
            lineMeanings.put(line.split("=")[0], line.split("=")[1]);		//мап со значениями и ключами-критериями
            values.add(line.split("=")[1]);	//лист со значениями
        }
    }

    // метод так и просится на рефакторинг
    // не недоа один огромный алгоритм запихивать в один метод и для этого придумывать методу огромадное имя
    // кроме имени метода у него есть еще параметры, что давать информацию о работе
    private static <E> boolean compareLineAndCriteria(Map<Object, Object> lineMeanings, Criteria<E> criteria){

        String lineKey, lineValue, criteriaKey, criteriaValue;
        boolean flag = false;

        for (Map.Entry<Object, Object> singleMeaning : lineMeanings.entrySet()) {						//цикл по значениям из строки

            flag = true;

            lineKey = singleMeaning.getKey().toString().toLowerCase();
            lineValue = singleMeaning.getValue().toString().toLowerCase();

            for (Map.Entry<E, Object> criteriaMeaning : criteria.getCriteria().entrySet()) {

                criteriaKey = criteriaMeaning.getKey().toString().toLowerCase();
                criteriaValue = criteriaMeaning.getValue().toString().toLowerCase();

                if ( lineKey.equals(criteriaKey) && lineValue.equals(criteriaValue) ) {
                    break;

                } else if ( lineKey.equals(criteriaKey) && !lineValue.equals(criteriaValue) ) {
                    flag = false;	//если значение по одинаковому ключу отличается -> неверный критерий	-> false
                    break;
                }
            }
            if (!flag) { //false? -> выходим из сравнения
                break;
            }
        }
        return flag;
    }
}
