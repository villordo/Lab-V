package com.company;

public class BeerConsumer extends Thread {
    BeerHouse beerHouse;

    public BeerConsumer(BeerHouse bh){
        this.beerHouse = bh;
    }
    public void run(){
        while (true){
            beerHouse.consumir();
        }
    }
}
