/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.shape;

import testing.lib.point.Point;
import static java.lang.Math.*;

/**
 *
 * @author yunl
 */
public class Rectangle<T extends Number> extends Shape {
    private T length ;
    private T width ;
    
    public Rectangle (Point p, T l, T w)
    {
        setCenter(p);
        setLength(l);
        setWidth(w);
    }
    public Rectangle (T a, T b, T l, T w)
    {
        this(new Point (a, b), l, w);
    }
    public Rectangle (Point p)
    {
        setCenter(p);
        setLength(0);
        setWidth(0);
    }
//    public Rectangle ()
//    {
//        centralPoint = new Point ();
//    }

    public T getWidth() {
        return width;
    }
    public void setWidth(Number w) {
        width = (T)w;
    }
    public T getLength() {
        return length;
    }
    public void setLength(Number l) {
        length = (T)l;
    }
    
    @Override
    public double getArea()
    {
        return getLength().doubleValue() * getWidth().doubleValue();
    }
    
    @Override
    public void printDescription (String st)
    {
        System.out.print("Print inside " + this.getClass().toString() + "\n");
        System.out.print("Centeral point at ");
        getCenter().printPoint(false);
        System.out.println("\nWidth: " + getWidth() + "; Length: " + getLength());
        System.out.println("Area: " + getArea());
        if (st != null) {
            System.out.println("Input string: " + st);
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + "; Width - " + getWidth() + "; Length - " + getLength() + "; Area - " + getArea();
    }
}
