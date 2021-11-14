package com.example.makespace.makespace.printResult;


import java.io.PrintWriter;

public class ResultPrintImpl implements ResultPrint {
    private PrintWriter printWriter = new PrintWriter(System.out);
    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    @Override
    public void printResult() {
        printWriter.write(input);
        System.exit(0);
    }



}
