/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.shape;

import testing.lib.point.*;
import java.lang.*;
import static java.lang.Math.*;

/**
 *
 * @author yunl
 */
public class Circle<T extends Number> extends Shape {
    private T radius;
    
    public Circle (Point<T> p, T r) {
        setCenter (p);
        setRadius (r);
    }
    public Circle (T a, T b, T r) {
        this(new Point(a, b), r);
    }
    public Circle (T r) {
        setRadius (r);
    }
    public Circle (Point<T> p) {
        setCenter (p);
    }
//    // redundant since 0/false/null is by default
//    public Circle ()
//    {
//        setRadius (0);
//        this (0);
//    }
    
    public T getRadius() {
        return radius;
    }
    public final void setRadius(Number r) {
        radius = (T)r;
    }
    
//    @Override
//    public Point<T> getCenter() {
//        return centralPoint;
//    }
//    @Override
//    public void setCenter(Point p) {
//        getCenter().move(p);
//    }
//    @Override
//    public void setCenter(T a, T b) {
//        setCenter(new Point(a, b));
//    }
    
    @Override
    public double getArea()
    {
        return Math.PI * sqrt(getRadius().doubleValue());
    }
    
    @Override
    public void printDescription (String st)
    {
        System.out.print("Print inside " + this.getClass().toString() + "\n");
        System.out.print("Centeral point at ");
        getCenter().printPoint(false);
        System.out.println("\nRadius: " + getRadius());
        System.out.println("Area: " + getArea());
        if (st != null) {
            System.out.println("Input string: " + st);
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + "; Radius - " + getRadius() + "; Area - " + getArea();
    }
}
