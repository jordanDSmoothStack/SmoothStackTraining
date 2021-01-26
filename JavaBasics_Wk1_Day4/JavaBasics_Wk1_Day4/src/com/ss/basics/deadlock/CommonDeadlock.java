package com.ss.basics.deadlock;

/*
 *
 * Class which implements that causes a deadlock
 * 
*/

public class CommonDeadlock {
    public static void main(String[] args) {
        final String a = "Jeff Bezos";
        final String b = "Elon Musk";
        
        //First thread
        Thread thread1 = new Thread(){
            public void run(){
                synchronized(a){
                    System.out.println("Locking " + a + " from making more money from Amazon");
                    try{
                        Thread.sleep(100);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized(b){
                        System.out.println("More money? Really?");
                    }
                }
            }
        };

        //Second thread
        Thread thread2 = new Thread(){
            public void run(){
                synchronized(b){
                    System.out.println("Locking " + b + " from making more money from Tesla");
                    try{
                        Thread.sleep(100);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized(a){
                        System.out.println("More money? Really?");
                    }
                }
            }
        };

        //Now we try to run the above threads
        System.out.println("Starting the billionaire race off");
        thread1.start();
        thread2.start();
        System.out.println("Ending the billionaire race off");

    }
}
