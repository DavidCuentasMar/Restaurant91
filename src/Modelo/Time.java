/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.CocinaView;

/**
 *
 * @author sony
 */
public class Time extends Thread {

    private CocinaView G;
    private int Seg;
    private int time; //buscar cuantos productos tiene un pedido
    public Time(CocinaView G, int timeXproductos) {
        this.G = G;
        Seg = G.getSeg();
        time = timeXproductos; 
    }

    @Override
    public void run() {
        for (;;) {
            if (Seg != time) {
                Seg = G.aumentSeg();
            } else {
                Seg = 0;
                G.resetSeg();
                G.parar();
                
            }
            try {
                sleep(999);
            } catch (InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
            if (!G.isContinuar()) {
                try {
                    synchronized (this) {
                        this.wait();
                    }
                } catch (InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        }
    }
}