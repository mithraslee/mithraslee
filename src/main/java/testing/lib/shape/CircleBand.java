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
public class CircleBand<T extends Number> extends Circle {
    private T radiusLarger;
    
    public CircleBand (Point<T> p, T r1, T r2) {
        super(p, Math.min(r1.doubleValue(), r2.doubleValue()));
        setLargerRadius(Math.max(r1.doubleValue(), r2.doubleValue()));
    }
    public CircleBand (Point<T> p, T r) {
        super(p, r);
        setLargerRadius(r.doubleValue()*2);
    }
    public CircleBand (T a, T b, T r1, T r2) {
        this(new Point(a, b), r1, r2);
    }
    public CircleBand (T r) {
        super(r);
        setLargerRadius (r.doubleValue()*2);
    }
    public CircleBand (Point<T> p) {
        super(p);
        setLargerRadius(1.1);
    }
    
    public T getLargerRadius() {
        return radiusLarger;
    }
    public final void setLargerRadius(Number r) {
        radiusLarger = (T)r;
    }
    
    @Override
    public double getArea() {
        return Math.PI * sqrt(getLargerRadius().doubleValue()) - super.getArea();
    }
    
    @Override
    public void printDescription (String st)
    {
        System.out.print("Print inside " + this.getClass().toString() + "\n");
        System.out.print("Centeral point at ");
        getCenter().printPoint(false);
        System.out.println("\nSmallRadius: " + getRadius());
        System.out.println("\nLargerRadius: " + getLargerRadius());
        System.out.println("Area: " + getArea());
        if (st != null) {
            System.out.println("Input string: " + st);
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + "; SmallRadius - " + getRadius() + "; LargerRadius - " + getLargerRadius() + "; Area - " + getArea();
    }
}

