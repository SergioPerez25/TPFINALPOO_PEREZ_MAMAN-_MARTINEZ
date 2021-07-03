package Metodos;

import Controlador.EmpleadosJpaController;
import Controlador.exceptions.NonexistentEntityException;
import Modelo.Empleados;
import Principal.Menus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author SERGIO
 */
public class MetodoEmpleados {

    Scanner scanner = new Scanner(System.in);
    Empleados emple = new Empleados();
    EmpleadosJpaController ejpaC = new EmpleadosJpaController();
    SimpleDateFormat fna = new SimpleDateFormat("dd/MM/yyyy");

    public void Insertar() {
        try {
            System.out.println("+========================================+");
            System.out.println("Ingrese Numero de legajo");
            emple.setNumLegajo(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Ingrese Nombre Y Apellido");
            emple.setNombreApellido(scanner.nextLine());
            System.out.println("Ingrese DNI");
            emple.setDni(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Ingrese Fecha de nacimiento (dia/mes/año)");
            String fech = scanner.nextLine();
            Date fecha = fna.parse(fech);
            emple.setFechaNacimineto(fecha);
            System.out.println("Ingrese Sueldo basico");
            emple.setSueldoBasico(scanner.nextDouble());
            scanner.nextLine();
            ejpaC.create(emple);
            System.out.println("+========================================+");
            System.out.println("Agregado correctamente");
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage() + " ingrese datos corectos");
            System.out.println("No se agrego");
        }
    }

    public int calcularEdad(Date fechaIngresada) {
        String fecha_nacimiento = fna.format(fechaIngresada);
        Date fechaActual = new Date();
        String hoy = fna.format(fechaActual);
        String[] fena = fecha_nacimiento.split("/");
        String[] feho = hoy.split("/");
        int año = Integer.parseInt(feho[2]) - Integer.parseInt(fena[2]);
        int mes = Integer.parseInt(feho[1]) - Integer.parseInt(fena[1]);
        if (mes < 0) {
            año--;
        } else if (mes == 0) {
            int dia = Integer.parseInt(feho[0]) - Integer.parseInt(fena[0]);
            if (dia > 0) {
                año--;
            }
        }
        return año;
    }

    public void Eliminar() {
        try {
            List<Empleados> emple = ejpaC.findEmpleadosEntities();
            int dni, nl, con = 0;
            System.out.println("+====================================+");
            System.out.println("+ Ingrese DNI para eliminar Empleado +");
            System.out.println("+====================================+");
            dni = scanner.nextInt();
            for (Empleados empleados : emple) {
                if (dni == empleados.getDni()) {
                    con++;
                    nl = empleados.getNumLegajo();
                    ejpaC.destroy(nl);
                    System.out.println("Se elimino correctamente");
                }
            }
            if (con == 0) {
                System.err.println("El DNI ingresado no se encuentra");
            }
        } catch (NonexistentEntityException e) {
            System.out.println("erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage() + " ingrese datos numericos");
            System.out.println("No se borro");
        }
    }

    public void Modificar() {
        try {
            Menus me = new Menus();
            Scanner modi = new Scanner(System.in);
            List<Empleados> emple = ejpaC.findEmpleadosEntities();
            int dni = 0, con = 0;
            System.out.println("+==================================================+");
            System.out.println("+ Ingrese DNI para modificar datos de ese Empleado +");
            System.out.println("+==================================================+");
            dni = scanner.nextInt();
            scanner.nextLine();
            for (Empleados empleados : emple) {
                if (dni == empleados.getDni()) {
                    con++;
                    int opp = 0;
                    while (opp != 5) {
                        System.out.println("+==================================+");
                        System.out.println("+===== Empleado: " + empleados.getNombreApellido() + " =====+");
                        System.out.println("+==================================+");
                        System.out.println("+ 1. Modificar Nombre y Apellido   +");
                        System.out.println("+ 2. Modificar Fecha de Nacimineto +");
                        System.out.println("+ 3. Modificar DNI                 +");
                        System.out.println("+ 4. Modificar Sueldo Basico       +");
                        System.out.println("+ 5. Salir de Modificar            +");
                        System.out.println("+    Ingrese opcion                +");
                        System.out.println("+==================================+");
                        opp = scanner.nextInt();
                        switch (opp) {
                            case 1:
                                System.out.println("Ingrese Nombre Y Apellido a modificar");
                                empleados.setNombreApellido(modi.nextLine());
                                ejpaC.edit(empleados);
                                System.out.println("Modificado correctamente");
                                Mostrartodo();
                                break;
                            case 2:
                                System.out.println("Ingrese Fecha de nacimiento a modificar (dia/mes/año)");
                                String fech = modi.nextLine();
                                Date fecha = fna.parse(fech);
                                empleados.setFechaNacimineto(fecha);
                                ejpaC.edit(empleados);
                                System.out.println("Modificado correctamente");
                                Mostrartodo();
                                break;
                            case 3:
                                System.out.println("Ingrese DNI a modificar");
                                empleados.setDni(scanner.nextInt());
                                scanner.nextLine();
                                ejpaC.edit(empleados);
                                break;
                            case 4:
                                System.out.println("Ingrese Sueldo basico a modificar");
                                empleados.setSueldoBasico(scanner.nextDouble());
                                scanner.nextLine();
                                ejpaC.edit(empleados);
                                System.out.println("Modificado correctamente");
                                Mostrartodo();
                                break;
                            case 5:
                                System.out.println("Saliendo de modificar");
                                me.menuEmpleados();
                                break;
                            default:
                                System.out.println("Opcion Incorrecta");
                        }
                    }
                }
            }
            if (con == 0) {
                System.err.println("El DNI ingresado no se encuentra");
            }
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
        }
    }

    public void Mostrartodo() {
        try {
            int cant = 0;
            List<Empleados> emple = ejpaC.findEmpleadosEntities();
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                  Lista de Empleados                                         +");
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            System.out.println("| Numero de legajo |     Nombre y Apellido    |  Fecha naciimeto  |     DNI    |   Sueldo Basico   |   EDAD   +");
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            Collections.sort(emple);
            for (Empleados empleados : emple) {
                cant++;
                System.out.printf("|        %-8s  |      %-15s     |    %-10s     |  %-8s  |      %-12s |    %-6s|\n",
                        empleados.getNumLegajo(),
                        empleados.getNombreApellido(),
                        fna.format(empleados.getFechaNacimineto()),
                        empleados.getDni(),
                        empleados.getSueldoBasico(),
                        calcularEdad(empleados.getFechaNacimineto()));
            }
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            System.out.println("|  Total de Empleados  |");
            System.out.println("+======================+");
            System.out.printf("|          %-6s      ]\n", cant);
            System.out.println("+======================+\n");
        } catch (Exception e) {
            System.out.println("erro" + e.getMessage());
        }
    }

    public void MayorEdad() {
        ArrayList<Integer> edad = new ArrayList<Integer>();
        ArrayList<Empleados> mayor = new ArrayList<Empleados>();
        List<Empleados> emple = ejpaC.findEmpleadosEntities();
        Empleados empl = new Empleados();
        edad = new ArrayList<Integer>();
        mayor = new ArrayList<Empleados>();
        int may, mayo, con, eda;
        try {
            for (Empleados empleados : emple) {
                may = calcularEdad(empleados.getFechaNacimineto());
                edad.add(may);
            }
            mayo = Collections.max(edad);
            for (Empleados empleados : emple) {
                con = calcularEdad(empleados.getFechaNacimineto());
                if (mayo == con) {
                    eda = empleados.getNumLegajo();
                    empl = ejpaC.findEmpleados(eda);
                    mayor.add(empl);
                }
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                              Empleado de mayor edad                                         +");
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        System.out.println("| Numero de legajo |     Nombre y Apellido    |  Fecha naciimeto  |     DNI    |   Sueldo Basico   |   EDAD   +");
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        for (int i = 0; i < mayor.size(); i++) {
            System.out.printf("|        %-8s  |      %-15s     |    %-10s     |  %-8s  |      %-12s |    %-6s|\n",
                    mayor.get(i).getNumLegajo(),
                    mayor.get(i).getNombreApellido(),
                    fna.format(mayor.get(i).getFechaNacimineto()),
                    mayor.get(i).getDni(),
                    mayor.get(i).getSueldoBasico(),
                    calcularEdad(mayor.get(i).getFechaNacimineto()));
        }
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
    }

    public void ListaEmpleSuel() {
        List<Empleados> emple = ejpaC.findEmpleadosEntities();
        float salba, con = 0;
        try {
            System.out.println("+=========================+");
            System.out.println("+  Ingrese Sueldo basico  +");
            System.out.println("+=========================+");
            salba = scanner.nextFloat();
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                  Lista de Empleados                                         +");
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            System.out.println("| Numero de legajo |     Nombre y Apellido    |  Fecha naciimeto  |     DNI    |   Sueldo Basico   |   EDAD   +");
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            for (Empleados empleados : emple) {
                if (salba <= empleados.getSueldoBasico()) {
                    con++;
                    System.out.printf("|        %-8s  |      %-15s     |    %-10s     |  %-8s  |      %-12s |    %-6s|\n",
                            empleados.getNumLegajo(),
                            empleados.getNombreApellido(),
                            fna.format(empleados.getFechaNacimineto()),
                            empleados.getDni(),
                            empleados.getSueldoBasico(),
                            calcularEdad(empleados.getFechaNacimineto()));
                }
            }
            if (con == 0) {
                System.err.println("No hay empleados que superen el slario ingresado");
            }
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");

        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }

    public void Buscar() {
        try {
            Menus me = new Menus();
            Scanner modi = new Scanner(System.in);
            List<Empleados> emple = ejpaC.findEmpleadosEntities();
            int dni = 0, con = 0;
            System.out.println("+===============================================+");
            System.out.println("+ Ingrese DNI para buscar datos de ese Empleado +");
            System.out.println("+===============================================+");
            dni = scanner.nextInt();
            scanner.nextLine();
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                  Lista de Empleados                                         +");
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            System.out.println("| Numero de legajo |     Nombre y Apellido    |  Fecha naciimeto  |     DNI    |   Sueldo Basico   |   EDAD   +");
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");
            for (Empleados empleados : emple) {
                if (dni == empleados.getDni()) {
                    con++;
                    System.out.printf("|        %-8s  |      %-15s     |    %-10s     |  %-8s  |      %-12s |    %-6s|\n",
                            empleados.getNumLegajo(),
                            empleados.getNombreApellido(),
                            fna.format(empleados.getFechaNacimineto()),
                            empleados.getDni(),
                            empleados.getSueldoBasico(),
                            calcularEdad(empleados.getFechaNacimineto()));
                }
            }
            if (con == 0) {
                System.err.println("El DNI ingresado no se encuentra");
            }
            System.out.println("+-------------------------------------------------------------------------------------------------------------+");

        } catch (EnumConstantNotPresentException e) {
            System.out.println("erro: " + e.getMessage());
        }
    }

}
