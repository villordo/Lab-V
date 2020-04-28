package com.company;

public class PrintBuffer {

    private boolean avaliable;
    private String data;


    public synchronized void setData(String value){ //"prodcuir"
        while(avaliable){ //"mientras haya un dato disponible quedate aca"
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Generando trabajo.");
        this.data = value; //setea la variable "produce"
        avaliable = true; //lo setea en true para indicar que hay datos disponibles para consumir
        notifyAll(); //desíerta a los hilos dormidos para que vuelvan a competir
    }

    public synchronized  String getData(){ //"consumir"
        while (!avaliable){ //mientras no haya datos para consumir,se quedaran esperando
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //cuando avaliable es true significa que el productos setio datos
        String currData = this.data; //lo consume
        avaliable = false; //vuelve la variable false
        notifyAll();// y despierta a los demas hilos que estan en wait para que vuelvan a competir
        return currData;
    }
}
