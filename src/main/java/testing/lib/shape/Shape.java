/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.shape;

import java.lang.*;
import testing.lib.point.*;
        
/**
 *
 * @author yunl
 */
public abstract class Shape<T extends Number> {
    private Point<T> centralPoint;
    public Point<T> getCenter () {
        return centralPoint;
    }
    public void setCenter (Point p) {
        centralPoint = new Point(p);
    }
    public void setCenter (T a, T b) {
        centralPoint = new Point<T>(a, b);
    }
    
    abstract public double getArea ();
    
    public abstract void printDescription (String st); 
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": central point - " + centralPoint.toString();
    }
}
