package com.company;

public class Printer extends Thread{ //consumidor

    PrintBuffer buffer;

    public Printer (PrintBuffer buffer){
        super();
        this.buffer = buffer;
    }

    public void run(){
        while (true){
            String data = buffer.getData();
            System.out.println(data);
        }
    }
}
