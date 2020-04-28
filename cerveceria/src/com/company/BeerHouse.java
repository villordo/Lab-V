package com.company;

public class BeerHouse {

    private int stock;

    public BeerHouse(int stock) {
        this.stock = stock;
    }

    public synchronized void producir(Integer value){
        while(this.stock >=100){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if ((this.stock+value)>100){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.stock += value;
        System.out.println("Se produjo birra,ahora hay: "+this.stock);
        notifyAll();
    }

    public synchronized void consumir(){
        while(this.stock == 0)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.stock -= 1;
        System.out.println("Se consumio birra, ahora hay: "+this.stock);
        notifyAll();
    }

}
