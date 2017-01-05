/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.point;

/**
 *
 * @author yunl
 */
public class Point<T extends Number> {
    private T x;
    private T y;
    
//    public Point () {
//        setX (0);//new Integer(0));
//        setY (0);
//    }
    public Point (T a, T b) {
        setX(a);
        setY(b);
    }
    public Point (Point p) {
        setX(p.getX());
        setY(p.getY());
    }
    
    public final void setX (Number a) {
        x = (T)a;
    }
    public final void setY (Number b) {
        y = (T)b;
    }
    public T getX () {
        return x;
    }
    public T getY () {
        return y;
    }
    
    public void move (T a, T b) {
        setX(a);
        setY(b);
    }
    public void move (Point<T> p) {
        setX(p.getX());
        setY(p.getY());
    }
    
    public void printPoint (boolean detail) {
        if (detail)
            System.out.print("x = " + getX() + "; y = " + getX());
        else
            System.out.print("(" + getX() + ", " + getX() + ")");
        
//        System.out.println("T type: " + x.getClass().toString());
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getX() + ")";
    }
}
