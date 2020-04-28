package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    BeerHouse bh = new BeerHouse(100);
    List<Integer> cervezas = new ArrayList<Integer>();
    cervezas.add(20);
    cervezas.add(13);
    cervezas.add(24);
    cervezas.add(25);
    cervezas.add(16);
    cervezas.add(17);
    cervezas.add(8);
    BeerProducter p = new BeerProducter(bh,cervezas);
    p.start();
    BeerConsumer c = new BeerConsumer(bh);
    c.start();
    }
}
