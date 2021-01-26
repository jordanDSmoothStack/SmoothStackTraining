package com.ss.basics.singleton;

/*
 *
 * Class which implements a singleton with a double checked lock
 * 
*/

public class Singleton{

    volatile private static Singleton ourInstance = null;
    public String example;
    public static Integer count = 0;

    // Default constructor for our Singleton which is private 
    private Singleton(){

        example = "This object has been instantiated";
        count++;

    }

    /*
     *
     * Function which returns ourInstance to our user
     * The function will call the constructor if the ourInstance variable is null
     * 
    */

    public static Singleton getInstance(){
        if (ourInstance == null){
            synchronized (Singleton.class){
                if (ourInstance == null){
                    ourInstance = new Singleton();
                }
            }
        }
        return ourInstance;
    }
}