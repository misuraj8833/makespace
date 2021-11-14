package com.example.makespace.makespace.ReadFromFile;

import com.example.makespace.makespace.printResult.ResultPrint;
import com.example.makespace.makespace.printResult.ResultPrintImpl;

import java.io.*;
public class CustomFileReaderImpl implements CustomFileReader
{
    private String line;
    private int count = 0;
    private String[] words;
    private ResultPrint resultPrint = new ResultPrintImpl();

    @Override
    public String[] readFile(String path)
    {
        try {
            FileReader file = new FileReader(path);
            BufferedReader br = new BufferedReader(file);
            while((line = br.readLine()) != null) {
                words = line.split(" ");
                count = count + words.length;
            }
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            resultPrint.setInput("FILE_NOT_FOUND");
            resultPrint.printResult();
        }
        catch (IOException ioException)
        {
            resultPrint.setInput("IO EXCEPTION OCCURRED");
            resultPrint.printResult();
        }

        return words;
    }

}
