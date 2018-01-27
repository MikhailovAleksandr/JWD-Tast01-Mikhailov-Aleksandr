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
        catch(Exception ex){
            ex.fillInStackTrace();
            return null;
        }
    }
}
