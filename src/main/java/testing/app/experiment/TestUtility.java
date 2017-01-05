/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testing.app.experiment;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yunl
 */
public class TestUtility {
    public static Object callMethod (Method func,  Object[] args) { //throws IllegalAccessException, InvocationTargetException {
        try {
            long startTime = System.nanoTime();

            Object[] parameters = Arrays.copyOfRange(args, 1, args.length);
            
            Object res = func.invoke(args[0], parameters);

            long endTime = System.nanoTime();

            long duration = (endTime - startTime);
            
            System.out.println("//////// Function " + func.getName() + " took " + duration + " nanoseconds ////////");
            
            return res;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(TestUtility.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static Object callMethodWithTimeReturn (Method func,  Object[] args) { //throws IllegalAccessException, InvocationTargetException {
        try {
            Object[] parameters = Arrays.copyOfRange(args, 1, args.length-1);
            
            Object res = func.invoke(args[0], parameters);

            long []runningTime = (long [])args[args.length-1];
            int times = runningTime.length;
            
            // Loop multiple times to calculate the average running time
            for (int i = 0; i < times; i++) {
                long startTime = System.nanoTime();
                
                func.invoke(args[0], parameters);
                
                long endTime = System.nanoTime();
                
                long duration = (endTime - startTime);
                
                runningTime[i] = duration;
            }
            
            return res;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(TestUtility.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Object callMethodNoStatic (Method func,  Object[] args) {
        try {
            long startTime = System.nanoTime();
            
            Object[] parameters = Arrays.copyOfRange(args, 1, args.length);
            
            Object res = func.invoke(args[0], parameters);

            long endTime = System.nanoTime();

            long duration = (endTime - startTime);
            
            System.out.println("//////// Function " + func.getName() + " took " + duration + " nanoseconds ////////");
            
            return res;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(TestUtility.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
