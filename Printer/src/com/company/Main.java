package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PrintBuffer buffer = new PrintBuffer();
        Printer printer = new Printer(buffer);
        printer.start();

        List<String> lines = new ArrayList<String>();
        lines.add("Line 1");
        lines.add("Line 2");
        lines.add("Line 3");
        lines.add("Line 4");
        lines.add("Line 5");
        lines.add("Line 6");
        lines.add("Line 7");
        lines.add("Line 8");
        lines.add("Line 9");

        PrintJob job = new PrintJob(lines,buffer);
        job.start();


    }
}
