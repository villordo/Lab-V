package com.company;

import java.util.ArrayList;
import java.util.List;
public class BeerProducter extends Thread{
    BeerHouse beerHouse;
    List<Integer> cerveza;

    public BeerProducter(BeerHouse bh ,List cerveza){
        this.beerHouse = bh;
        this.cerveza=cerveza;
    }

    public void run(){
        for(Integer beer : cerveza){
            beerHouse.producir(beer);
        }
    }
}
