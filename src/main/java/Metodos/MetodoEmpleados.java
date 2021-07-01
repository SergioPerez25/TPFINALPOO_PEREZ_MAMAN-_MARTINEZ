package Metodos;

import Controlador.EmpleadosJpaController;
import Modelo.Empleados;
import java.util.Scanner;

/**
 *
 * @author SERGIO
 */
public class MetodoEmpleados {

    Scanner scanner = new Scanner(System.in);
    Empleados emple = new Empleados();
    EmpleadosJpaController ejpaC = new EmpleadosJpaController();
    private String mensaje = "";

    public void Insertar() {
        try {
            System.out.println("Ingrese DNI");
            emple.setDni(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Ingrese Nombre");
            emple.setNombre(scanner.nextLine());
            System.out.println("Ingrese Apellido");
            emple.setApellido(scanner.nextLine());
            System.out.println("Ingrese Fecha de nacimiento");
//            emple.setFechaNacimineto(scanner.);
            System.out.println("Ingrese Numero de legajo");
            emple.setNumLegajo(scanner.nextInt());
            System.out.println("Ingrese Sueldo basico");
            emple.setSueldoBasico(scanner.nextDouble());
            ejpaC.create(emple);
            scanner.nextLine();
            System.out.println("Agregado correctamente");
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
            System.out.println("No se agrego");
        }

    }
}
