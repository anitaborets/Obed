package com.engeto;

import java.util.concurrent.atomic.AtomicInteger;

public class Filozof extends Thread {
    public int number = 0;
    private Spoon right;
    private Spoon left;


    Filozof(int number,Spoon right, Spoon left){
        this.number = number;
        this.right = right;
        this.left = left;

    }

        private void relax()throws InterruptedException{
        Thread.sleep(200);
    }

    @Override
    public void run() {
        int count = 0;

        try {

                while(count < 10) {
                    relax();
                    System.out.println("Filozof " + number + " relaxuje");
                    synchronized (left) {
                        relax();
                        synchronized (right) {
                            relax();
                            System.out.println("Filozof " + number + " obeduje");

                            relax();
                        }
                        relax();
                        count++;
                        System.out.println("Filozof " + number + " zjedol porcii " + count);
                    }
                }
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }

        }

    }

