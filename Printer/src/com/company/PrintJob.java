package com.company;

import java.util.List;

public class PrintJob extends Thread { //productor

    List<String> lines;
    PrintBuffer buffer;

    public PrintJob(List<String> lines,PrintBuffer buffer){
        super();
        this.lines = lines;
        this.buffer = buffer;
    }

    public void run(){
        for(String line : lines){
            buffer.setData(line);
        }
    }
}
