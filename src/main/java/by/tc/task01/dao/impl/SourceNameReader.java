package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public final class SourceNameReader {

    private static SourceNameReader sourceNameReader = new SourceNameReader();

    public static SourceNameReader getInstanse(){

        return sourceNameReader;
    }

    public String read(){

        try {
            FileInputStream fstream = new FileInputStream("by/tc/task01/dao/impl/resources.txt");
            BufferedReader buffer = new BufferedReader(new InputStreamReader(fstream));
            return buffer.readLine().split("[=]")[1];
        }
        catch(Exception ex){// Exception????????
            ex.fillInStackTrace();// эм, а зачем ты тут вызываешь этот метод. Очень хочется спросить, знаешь ли ты зачем этот метод надо использовать
            return null;
        }
    }
}
