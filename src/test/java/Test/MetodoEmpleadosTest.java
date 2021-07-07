/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Metodos.MetodoEmpleados;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SERGIO
 */
public class MetodoEmpleadosTest {

    public MetodoEmpleadosTest() {

    }

    @Test
    public void testCalcularEdad() {
        try {
            SimpleDateFormat fechapr = new SimpleDateFormat("dd/MM/yyyy");
            String fecha1 = "12/8/1999";
            Date fech = fechapr.parse(fecha1);
            System.out.println("calcularEdad");
            Date fechaIngresada = fech;
            MetodoEmpleados instance = new MetodoEmpleados();
            int expResult = 22;
//            int result = instance.calcularEdad(fechaIngresada);
//            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
        } catch (ParseException ex) {
            Logger.getLogger(MetodoEmpleadosTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      @Test
    public void testCalcularEdad1() {
        try {
            SimpleDateFormat fechapr = new SimpleDateFormat("dd/MM/yyyy");
            String fecha1 = "3/4/1996";
            Date fech = fechapr.parse(fecha1);
            System.out.println("calcularEdad");
            Date fechaIngresada = fech;
            MetodoEmpleados instance = new MetodoEmpleados();
            int expResult = 25;
//            int result = instance.calcularEdad(fechaIngresada);
//            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
        } catch (ParseException ex) {
            Logger.getLogger(MetodoEmpleadosTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      @Test
    public void testCalcularEdad2() {
        try {
            SimpleDateFormat fechapr = new SimpleDateFormat("dd/MM/yyyy");
            String fecha1 = "12/11/1997";
            Date fech = fechapr.parse(fecha1);
            System.out.println("calcularEdad");
            Date fechaIngresada = fech;
            MetodoEmpleados instance = new MetodoEmpleados();
            int expResult = 23;
//            int result = instance.calcularEdad(fechaIngresada);
//            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
        } catch (ParseException ex) {
            Logger.getLogger(MetodoEmpleadosTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      @Test
    public void testCalcularEdad3() {
        try {
            SimpleDateFormat fechapr = new SimpleDateFormat("dd/MM/yyyy");
            String fecha1 = "10/9/2000";
            Date fech = fechapr.parse(fecha1);
            System.out.println("calcularEdad");
            Date fechaIngresada = fech;
            MetodoEmpleados instance = new MetodoEmpleados();
            int expResult = 21;
//            int result = instance.calcularEdad(fechaIngresada);
//            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
        } catch (ParseException ex) {
            Logger.getLogger(MetodoEmpleadosTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      @Test
    public void testCalcularEdad4() {
        try {
            SimpleDateFormat fechapr = new SimpleDateFormat("dd/MM/yyyy");
            String fecha1 = "09/1/1995";
            Date fech = fechapr.parse(fecha1);
            System.out.println("calcularEdad");
            Date fechaIngresada = fech;
            MetodoEmpleados instance = new MetodoEmpleados();
            int expResult = 27;
//            int result = instance.calcularEdad(fechaIngresada);
//            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
        } catch (ParseException ex) {
            Logger.getLogger(MetodoEmpleadosTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testCalcularEdad5() {
        try {
            SimpleDateFormat fechapr = new SimpleDateFormat("dd/MM/yyyy");
            String fecha1 = "03/7/1994";
            Date fech = fechapr.parse(fecha1);
            System.out.println("calcularEdad");
            Date fechaIngresada = fech;
            MetodoEmpleados instance = new MetodoEmpleados();
            int expResult = 28;
//            int result = instance.calcularEdad(fechaIngresada);
//            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
        } catch (ParseException ex) {
            Logger.getLogger(MetodoEmpleadosTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testCalcularEdad6() {
        try {
            SimpleDateFormat fechapr = new SimpleDateFormat("dd/MM/yyyy");
            String fecha1 = "05/8/1993";
            Date fech = fechapr.parse(fecha1);
            System.out.println("calcularEdad");
            Date fechaIngresada = fech;
            MetodoEmpleados instance = new MetodoEmpleados();
            int expResult = 29;
//            int result = instance.calcularEdad(fechaIngresada);
//            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
        } catch (ParseException ex) {
            Logger.getLogger(MetodoEmpleadosTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
