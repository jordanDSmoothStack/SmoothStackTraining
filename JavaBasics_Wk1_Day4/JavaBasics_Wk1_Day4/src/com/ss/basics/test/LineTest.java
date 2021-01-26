package com.ss.basics.test;

import com.ss.basics.line.Line;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class LineTest {
    
    private Line closePoint = new Line(0.0, 0.0, 0.99999, 0.99999);
    private Line positiveLine = new Line(0.0, 0.0, 1.0, 1.0);
    private Line negativeLine = new Line(0.0, 1.0, 1.0, 0.0);
    private Line horizontalLine = new Line(0.0, 0.0, 1.0, 0.0);
    private Line verticalLine = new Line(0.0, 0.0, 0.0, 1.0);
    private Line positiveLineIncreasedMag = new Line(0.0, 0.0, 5.0, 5.0);
    private Line randomPoints = new Line(2.0, 8.0, -2.0, 16.0);

    @Test
    public void checkSlope(){
        assertEquals(1.0, closePoint.getSlope(), .0001);
        assertEquals(1.0, positiveLine.getSlope(), .0001);
        assertEquals(-1.0, negativeLine.getSlope(), .0001);
        assertEquals(0.0, horizontalLine.getSlope(), .0001);
        assertEquals(1.0, positiveLineIncreasedMag.getSlope(), 0.0001);
        assertEquals(-2.0, randomPoints.getSlope(), 0.0001);
    }

    @Test (expected = ArithmeticException.class)
    public void checkImpossibleSlope(){
        verticalLine.getSlope();
    }

    @Test
    public void getDistance(){
        assertEquals(Math.sqrt(2), positiveLine.getDistance(), .0001);
        assertEquals(Math.sqrt(2), negativeLine.getDistance(), .0001);
        assertEquals(1.0, horizontalLine.getDistance(), .0001);
        assertEquals(1.0, verticalLine.getDistance(), .0001);
        assertEquals(Math.sqrt(50), positiveLineIncreasedMag.getDistance(), .0001);
        assertEquals(Math.sqrt(80), randomPoints.getDistance(), .0001);
    }

    @Test
    public void checkParallel(){
        assertEquals(true, positiveLine.parallelTo(positiveLineIncreasedMag));
        assertEquals(true, positiveLine.parallelTo(closePoint));
        assertEquals(false, positiveLine.parallelTo(negativeLine));
        assertEquals(false, horizontalLine.parallelTo(negativeLine));
        assertEquals(false, randomPoints.parallelTo(positiveLine));
    }

    @Test (expected = ArithmeticException.class)
    public void checkImpossibleParallel(){
        verticalLine.parallelTo(positiveLine);
        verticalLine.parallelTo(horizontalLine);
    }
}
