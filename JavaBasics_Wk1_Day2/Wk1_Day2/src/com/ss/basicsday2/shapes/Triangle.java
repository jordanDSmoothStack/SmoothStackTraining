package com.ss.basicsday2.shapes;

public class Triangle implements Shapes {

    private double width, height;

    public Triangle(){
        this.width = 1.0;
        this.height = 1.0;
    }

    public Triangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height * (1/2);

    }
}
