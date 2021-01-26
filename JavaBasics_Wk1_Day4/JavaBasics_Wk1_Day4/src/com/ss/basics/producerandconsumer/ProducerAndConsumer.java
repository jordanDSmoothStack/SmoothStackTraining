package com.ss.basics.producerandconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
 *
 * Class which creates a Producer and a Consumer
 * which take elements from the same array
 * The producer produces random numbers and put thems into the array
 * While the consumer consumes the number
 * 
*/

public class ProducerAndConsumer {

    public static Integer counter = 0;
    public static Integer dollarAmount = 0;
    
    public static void main(String[] args) {
        Random r = new Random();
        List <Integer> stockMarket = new ArrayList<Integer>(10);
        stockMarket.add(0);

        Thread producer = new Thread(){
            public void run(){
                while (counter < 500){
                    synchronized(stockMarket){
                        try{
                            if (stockMarket.size() == 10){
                                Thread.sleep(50);
                            }
                            else{
                                Integer tempVal = r.nextInt(100) + 1;
                                stockMarket.add(tempVal);
                                Thread.sleep(50);
                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        } finally{
                            counter += 1;
                        }
                    }
                }
            }
        };

        Thread consumer = new Thread(){
            public void run(){
                while (counter < 500){
                    synchronized(stockMarket){
                        try{
                            if (stockMarket.size() == 0){
                                Thread.sleep(50);
                            }
                            else{
                                Integer tempVal = stockMarket.get(0);
                                dollarAmount += tempVal * 2;
                                System.out.println("Made $" + dollarAmount + " from the stock market");
                                stockMarket.remove(0);
                                Thread.sleep(50);
                            }
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        } finally{
                            counter += 1;
                        }
                    }
                }
            }
        };

        producer.start();
        consumer.start();
    }
}
