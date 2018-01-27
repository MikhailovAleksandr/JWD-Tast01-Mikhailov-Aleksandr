package by.tc.task01.dao.impl;

import java.util.Map;
import java.util.Set;

public class ComparatorForFileLineAndCriteriaParameters {


    public static <E> boolean compare(Map<String, Object> fileLineMeanings, Map<E, Object> criterias){
        int counterOfMatches = 0;
        for(Map.Entry<E, Object> criteria : criterias.entrySet()){

            String fileLineMeaning = fileLineMeanings.get( criteria.getKey().toString()).toString().toLowerCase();
            String criteriaMeaning = criteria.getValue().toString().toLowerCase();
            if(fileLineMeaning.equals(criteriaMeaning)){
                counterOfMatches++;
            }
        }
        if(counterOfMatches == criterias.size()) {
            return true;
        }
        else return false;
    }
}
