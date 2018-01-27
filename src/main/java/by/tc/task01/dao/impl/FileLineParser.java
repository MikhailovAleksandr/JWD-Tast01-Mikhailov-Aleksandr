package by.tc.task01.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileLineParser {

    private static Pattern patternForParse;

    static{
        patternForParse = Pattern.compile("\\S+[=](\\w+\\W\\w|\\w+)");
    }

    public static void parseLine(String line, Map<String, Object> fileLineMeanings, List<Object> values){

        Matcher matches = patternForParse.matcher(line);
        fileLineMeanings.clear();

        while (matches.find()) {	// поиск всех совпадений в строке
            line = matches.group();
            fileLineMeanings.put(line.split("=")[0], line.split("=")[1]);
            values.add(line.split("=")[1]);
        }
    }
}
