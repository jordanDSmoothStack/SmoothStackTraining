package com.ss.basicsday2.shapes;


public class Circle implements Shapes{

    private double radius;

    public Circle(){
        this.radius = 1.0;
    }

    public Circle(double r){
        this.radius = r;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
