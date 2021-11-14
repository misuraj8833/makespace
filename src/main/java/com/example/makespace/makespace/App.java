package com.example.makespace.makespace;

import com.example.makespace.makespace.HelperPackage.SuperHelper;
import com.example.makespace.makespace.HelperPackage.SuperHelperImpl;
import com.example.makespace.makespace.ReadFromFile.CustomFileReader;
import com.example.makespace.makespace.ReadFromFile.CustomFileReaderImpl;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static String filePath;

    public static void main( String[] args )
    {
        filePath = args[0];
        CustomFileReader customFileReader = new CustomFileReaderImpl();
        String [] returnedWords = customFileReader.readFile(filePath);
        SuperHelper superHelper = new SuperHelperImpl();
        List<String> returnedList = superHelper.returnedWordsProcessInput(returnedWords);
        if(returnedList!=null) {
            for (String s : returnedList) {
                System.out.println(s);
            }
        }
    }
}

