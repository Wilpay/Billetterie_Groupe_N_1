/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Properties;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
/**
 *
 * @author Willy
 */
public class Reader {
    
     public static String readString(String searchedString) {
        Properties pReader = new Properties();
        try {
            System.out.println(pReader);
            System.out.println(Reader.class.getResourceAsStream("properties.properties"));
            pReader.load(Reader.class.getResourceAsStream("properties.properties"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pReader.getProperty(searchedString);
    }

    public static List<String> readStrings(String searchedString) {
        Properties pReader = new Properties();
        try {
            pReader.load(Reader.class.getResourceAsStream("properties.properties"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Arrays.asList(pReader.getProperty(searchedString).split(","));
    }
}
