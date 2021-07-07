package Metodos;

import Controlador.EmpleadosJpaController;
import Controlador.ProyectoJpaController;
import Controlador.exceptions.NonexistentEntityException;
import Modelo.Empleados;
import Modelo.Proyecto;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author SERGIO
 */
public class MetodoProyectos {

    Scanner scanner = new Scanner(System.in);
    ProyectoJpaController pjpaC = new ProyectoJpaController();
    Proyecto pro = new Proyecto();
    SimpleDateFormat fechapr = new SimpleDateFormat("dd/MM/yyyy");

    public void Agregar() {
        try {
            System.out.println("+======================================================+");
            System.out.println("Ingrese codigo de proyecto");
            pro.setCodigoProyecto(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Igrese nombre de proyecto");
            pro.setNombreProyecto(scanner.nextLine());
            System.out.println("Ingrese fecha de inicio del proyecto (dia/mes/año)");
            String fechain = scanner.nextLine();
            Date fech = fechapr.parse(fechain);
            pro.setFechaInicio(fech);
            System.out.println("Ingrese fecha de finalisacion del proyecto (dia/mes/año)");
            String fechafin = scanner.nextLine();
            Date fechaf = fechapr.parse(fechafin);
            pro.setFechaFinalizacion(fechaf);
            System.out.println("Ingrese el monto prosupuestado");
            pro.setMontoProsupuestado(scanner.nextDouble());
            scanner.nextLine();
            System.out.println("+======================================================+");
            pjpaC.create(pro);
            System.out.println("Agregado correctamente");
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage() + " ingrese datos validos");
            System.out.println("No se agrego");
        }

    }

    public void Eliminar() {
        try {
            List<Proyecto> proy = pjpaC.findProyectoEntities();
            int cod, nl, con = 0;
            System.out.println("+=======================================+");
            System.out.println("+ Ingrese Codigo para eliminar Proyecto +");
            System.out.println("+=======================================+");
            cod = scanner.nextInt();
            for (Proyecto proyecto : proy) {
                if (cod == proyecto.getCodigoProyecto()) {
                    con++;
                    nl = proyecto.getCodigoProyecto();
                    pjpaC.destroy(nl);
                    System.out.println("Se elimino correctamente");
                }
            }
            if (con == 0) {
                System.err.println("El Codigo ingresado no se encuentra");
            }
        } catch (NonexistentEntityException e) {
            System.out.println("erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage() + " ingrese datos numericos");
            System.out.println("No se borro");
        }
    }

    public void Mostrartodo() {
        try {
            List<Proyecto> proy = pjpaC.findProyectoEntities();
            System.out.println("+-------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                          Lista de Proyectos                                           +");
            System.out.println("+-------------------------------------------------------------------------------------------------------+");
            System.out.println("|  Codigo  |    Nombre proyecto    |  Fecha de inicio  |  Fecha de finalizacion  |  Monto prosupuestado +");
            System.out.println("+-------------------------------------------------------------------------------------------------------+");
            for (Proyecto proyecto : proy) {
                System.out.printf("|    %-4s  |      %-15s  |    %-10s     |        %-10s       |       %-12s   |\n",
                        proyecto.getCodigoProyecto(),
                        proyecto.getNombreProyecto(),
                        fechapr.format(proyecto.getFechaInicio()),
                        fechapr.format(proyecto.getFechaFinalizacion()),
                        proyecto.getMontoProsupuestado());
            }
            System.out.println("+-------------------------------------------------------------------------------------------------------+");
        } catch (Exception e) {
            System.out.println("erro" + e.getMessage());
        }
    }

    public void AgregarEmpleado() {
        try {
            Empleados emple = new Empleados();
            EmpleadosJpaController ejpaC = new EmpleadosJpaController();
            List<Empleados> empl = ejpaC.findEmpleadosEntities();
            Scanner modi = new Scanner(System.in);
            List<Proyecto> proy = pjpaC.findProyectoEntities();
            MetodoEmpleados emp = new MetodoEmpleados();
            Mostrartodo();
            int cod = 0, con = 0, lega = 0, cont = 0;
            System.out.println("+=======================================================+");
            System.out.println("+ Ingrese codigo de proyecto para agregar a un Empleado +");
            System.out.println("+=======================================================+");
            cod = modi.nextInt();
            modi.nextLine();

            for (Proyecto proyecto : proy) {
                if (cod == proyecto.getCodigoProyecto()) {
                    con++;
                    emp.Mostrartodo();
                    System.out.println("+===================================================================+");
                    System.out.println("+ Ingrese el numero de legajo del empleado para asignar al proyecto +");
                    System.out.println("+===================================================================+");
                    lega = modi.nextInt();
                    modi.nextLine();
                    for (Empleados empleados : empl) {
                        if (lega == empleados.getNumLegajo()) {
                            cont++;
                            empleados.setNumLegajo(lega);
                            empleados.setCodigoProyecto(cod);
                            ejpaC.edit(empleados);
                            System.out.println("Se agrego correctamente");
                        }
                    }
                    if (cont == 0) {
                        System.out.println("El legajo ingresado no existe");
                    }

                }
            }
            if (con == 0) {
                System.out.println("El codigo ingresado no existe");
            }

        } catch (Exception e) {
            System.out.println("errar: " + e.getMessage());
        }
    }

    public void QuitarEmpleado() {
        try {
            Empleados emple = new Empleados();
            EmpleadosJpaController ejpaC = new EmpleadosJpaController();
            List<Empleados> empl = ejpaC.findEmpleadosEntities();
            Scanner modi = new Scanner(System.in);
            List<Proyecto> proy = pjpaC.findProyectoEntities();
            MetodoEmpleados emp = new MetodoEmpleados();
            Mostrartodo();
            int cod = 0, con = 0, cont = 0, lega = 0;
            System.out.println("+======================================================+");
            System.out.println("+ Ingrese codigo de proyecto para quitar a un Empleado +");
            System.out.println("+======================================================+");
            cod = modi.nextInt();
            modi.nextLine();

            for (Proyecto proyecto : proy) {
                if (cod == proyecto.getCodigoProyecto()) {
                    con++;
                    System.out.println("+===============================================================+");
                    System.out.println("+ Ingrese el numero de legajo para quitar empleado del proyecto +");
                    System.out.println("+===============================================================+");
                    lega = modi.nextInt();
                    modi.nextLine();
                    for (Empleados empleados : empl) {
                        if (lega == empleados.getNumLegajo() && cod == empleados.getCodigoProyecto()) {
                            cont++;
                            empleados.setCodigoProyecto(0);
                            ejpaC.edit(empleados);
                            System.out.println("Se quito correctamente");
                        }
                    }
                }

            }
            if (cont == 0) {
                System.out.println("No se puede quitar porque el proyecto no tiene ese empleado");
            }
            if (con == 0) {
                System.out.println("El codigo ingresado no existe");
            }

        } catch (Exception e) {
            System.out.println("errar: " + e.getMessage());
        }
    }

    public void ListarDatosPreoyecto() {
        try {
            Scanner modi = new Scanner(System.in);
            List<Proyecto> proy = pjpaC.findProyectoEntities();
            EmpleadosJpaController ejpaC = new EmpleadosJpaController();
            List<Empleados> emple = ejpaC.findEmpleadosEntities();
            MetodoEmpleados emp = new MetodoEmpleados();
            int cod = 0, con = 0, entro = 0, aa = 0;
            Mostrartodo();
            System.out.println("+==============================================+");
            System.out.println("+ Ingrese codigo de proyecto para listar datos +");
            System.out.println("+==============================================+");
            cod = modi.nextInt();
            modi.nextLine();
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                    Datos de Proyecto                                                                         +");
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|  Codigo  |    Nombre proyecto    |  Fecha de inicio  |  Fecha de finalizacion  |  Monto prosupuestado | N° Legajo |     Nombre y Apellido    |");
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------+");
            for (Proyecto proyecto : proy) {
                if (cod == proyecto.getCodigoProyecto()) {
                    aa++;
                    for (Empleados empleados : emple) {
                        if (cod == empleados.getCodigoProyecto()) {
                            con++;
                            entro++;
                            System.out.printf("|    %-4s  |      %-15s  |    %-10s     |        %-10s       |       %-12s   |     %-4s  |      %-15s     |\n",
                                    empleados.getCodigoProyecto(),
                                    proyecto.getNombreProyecto(),
                                    fechapr.format(proyecto.getFechaInicio()),
                                    fechapr.format(proyecto.getFechaFinalizacion()),
                                    proyecto.getMontoProsupuestado(),
                                    empleados.getNumLegajo(),
                                    empleados.getNombreApellido());
                        }
                    }
                }

            }
            if (aa == 0) {
                System.out.println("El codigo de proyecto que ingreso no existe");
            }
            if (entro == 0 && aa > 0) {
                System.err.println("El Proyecto no tiene empleados");
            }
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("| Total de empleados en el proyecto:      " + con + "                                                                                                    |");
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------+");

        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
        }

    }

    public void CalculoMontoTotal() {
        List<Proyecto> proy = pjpaC.findProyectoEntities();
        double montoTo = 0;
        for (Proyecto proyecto : proy) {
            montoTo = montoTo + proyecto.getMontoProsupuestado();

        }
        Mostrartodo();
        System.out.println("|  Monto total de prosupuesto a proyectos |");
        System.out.println("+=========================================+");
        System.out.printf("|               %-20s      ]\n", montoTo);
        System.out.println("+=========================================+\n");
    }

    public float calcularMontoIndividual() {
        float montoind = 0;
        int cod = 0, con = 0;
        try {
            Scanner modi = new Scanner(System.in);
            List<Proyecto> proy = pjpaC.findProyectoEntities();
            EmpleadosJpaController ejpaC = new EmpleadosJpaController();
            List<Empleados> emple = ejpaC.findEmpleadosEntities();
            MetodoEmpleados emp = new MetodoEmpleados();
            Mostrartodo();
            System.out.println("+==========================================================+");
            System.out.println("+ Ingrese codigo de proyecto para listar monto de empleado +");
            System.out.println("+==========================================================+");
            cod = modi.nextInt();
            modi.nextLine();
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                                    Datos de Proyecto                                                                         +");
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("|  Codigo  |    Nombre proyecto    |  Fecha de inicio  |  Fecha de finalizacion  |  Monto prosupuestado | N° Legajo |     Nombre y Apellido    |");
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------+");
            for (Proyecto proyecto : proy) {
                if (cod == proyecto.getCodigoProyecto()) {
                    for (Empleados empleados : emple) {
                        if (cod == empleados.getCodigoProyecto()) {
                            con++;
                            montoind = (float) (proyecto.getMontoProsupuestado() / con);
                            System.out.printf("|    %-4s  |      %-15s  |    %-10s     |        %-10s       |       %-12s   |     %-4s  |      %-15s     |\n",
                                    empleados.getCodigoProyecto(),
                                    proyecto.getNombreProyecto(),
                                    fechapr.format(proyecto.getFechaInicio()),
                                    fechapr.format(proyecto.getFechaFinalizacion()),
                                    proyecto.getMontoProsupuestado(),
                                    empleados.getNumLegajo(),
                                    empleados.getNombreApellido());
                        }
                    }
                }
            }
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("| Total de empleados en el proyecto:      " + con + "                                                                                                    |");
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------+");

        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
        }
        return montoind;
    }

    public void ListarPorRangoFecha() {
        List<Proyecto> proy = pjpaC.findProyectoEntities();

        try {
            System.out.println("Ingrese fecha de inicio del proyecto (dia/mes/año)");
            String fechain = scanner.nextLine();
            Date fech = fechapr.parse(fechain);
            System.out.println("Ingrese fecha de finalisacion del proyecto (dia/mes/año)");
            String fechafin = scanner.nextLine();
            Date fechaf = fechapr.parse(fechafin);
            System.out.println("+-------------------------------------------------------------------------------------------------------+");
            System.out.println("|                                       Datos de Proyecto                                               +");
            System.out.println("+-------------------------------------------------------------------------------------------------------+");
            System.out.println("|  Codigo  |    Nombre proyecto    |  Fecha de inicio  |  Fecha de finalizacion  |  Monto prosupuestado |");
            System.out.println("+-------------------------------------------------------------------------------------------------------+");
            for (Proyecto proyecto : proy) {
            if(fech.compareTo(proyecto.getFechaInicio())<=0 && fechaf.compareTo(proyecto.getFechaFinalizacion()) >=0){    
             System.out.printf("|    %-4s  |      %-15s  |    %-10s     |        %-10s       |       %-12s   |\n",
                            proyecto.getCodigoProyecto(),
                            proyecto.getNombreProyecto(),
                            fechapr.format(proyecto.getFechaInicio()),
                            fechapr.format(proyecto.getFechaFinalizacion()),
                            proyecto.getMontoProsupuestado());
                }
            }
            System.out.println("+-------------------------------------------------------------------------------------------------------+");
        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
        }
    }
}