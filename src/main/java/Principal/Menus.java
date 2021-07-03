package Principal;

import Metodos.MetodoEmpleados;
import java.util.Scanner;

/**
 *
 * @author SERGIO
 */
public class Menus {
    
    public static Scanner scanner = new Scanner(System.in);

    public static void menuPrincipal() {
        int opp = 0;
        while (opp != 3) {
            System.out.println("+================================+");
            System.out.println("+==== MUNICIPIO DE LA QUIACA ====+");
            System.out.println("+================================+");
            System.out.println("+     1. Empleados               +");
            System.out.println("+     2. Proyectos               +");
            System.out.println("+     3. Salir del Programa      +");
            System.out.println("+         Ingrese opcion         +");
            System.out.println("+================================+");
            opp = scanner.nextInt();
            switch (opp) {
                case 1:
                    menuEmpleados();
                    break;
                case 2:
                    menuProyactos();
                    break;
                case 3:
                    System.out.println("Saliendo del Programa");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
            }
        }
    }

    public static void menuEmpleados() {
        MetodoEmpleados me = new MetodoEmpleados();
        int opp = 0;
        while (opp != 8) {
            System.out.println("+=============================================================================+");
            System.out.println("+================================= EMPLEADOS =================================+");
            System.out.println("+=============================================================================+");
            System.out.println("+  1. Agregar empleado                                                        +");
            System.out.println("+  2. Eliminar empleado                                                       +");
            System.out.println("+  3. Modificar empleado                                                      +");
            System.out.println("+  4. Listar empleados                                                        +");
            System.out.println("+  5. Mostrar el empleado de mayor edad                                       +");
            System.out.println("+  6. Listar empleados que superen a un determinado sueldo básico ingresado   +");
            System.out.println("+  7. Buscar empleado                                                         +");
            System.out.println("+  8. Salir de empleado                                                       +");
            System.out.println("+         Ingrese opcion                                                      +");
            System.out.println("+=============================================================================+");
            opp = scanner.nextInt();
            switch (opp) {
                case 1:
                    me.Insertar();
                    me.Mostrartodo();
                    break;
                case 2:
                    me.Eliminar();
                    me.Mostrartodo();
                    break;
                case 3:
                    me.Modificar();
                    break;
                case 4:
                    me.Mostrartodo();
                    break;
                case 5:
                    me.MayorEdad();
                    break;
                case 6:
                    me.ListaEmpleSuel();
                    break;
                case 7:
                    me.Buscar();
                    break;
                case 8:
                    System.out.println("Saliendo del Administrador de Empleados");
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
            }
        }
    }

    public static void menuProyactos() {
        int opp = 0;
        while (opp != 10) {
            System.out.println("+=====================================================================+");
            System.out.println("+============================= PROYECTOS =============================+");
            System.out.println("+=====================================================================+");
            System.out.println("+  1. Agregar un nuevo proyecto                                       +");
            System.out.println("+  2. Eliminar un proyecto                                            +");
            System.out.println("+  3. Listar proyectos                                                +");
            System.out.println("+  4. Agregar empleado a un proyecto                                  +");
            System.out.println("+  5. Quitar empleado de un proyecto                                  +");
            System.out.println("+  6. Listar datos de un proyecto                                     +");
            System.out.println("+  7. Calcular el total de montos destinados a proyectos              +");
            System.out.println("+  8. Calcular el monto que recibe cada participante de un proyecto   +");
            System.out.println("+  9. Listar proyectos por rangos de fechas                           +");
            System.out.println("+  10. Salir de Proyectos                                             +");
            System.out.println("+         Ingrese opcion                                              +");
            System.out.println("+=====================================================================+");
            opp = scanner.nextInt();
            switch (opp) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:
                    System.out.println("Saliendo del Administrador de Proyectos");
                    menuPrincipal();
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
            }
        }
    }

}
