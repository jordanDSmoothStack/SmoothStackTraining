package com.ss.basicsday2.shapes;

public interface Shapes {

    /*
     * Calculates the area based on parameters given when it is used for extending
     * Abstract class
    */

    double calculateArea();

    /*
     * Displays the area of a shape after computation
     * Default
    */
    default void display(){
        System.out.println(calculateArea());
    }
}
