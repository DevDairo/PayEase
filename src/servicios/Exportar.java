package servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import modelo.Empleado;
import modelo.EmpleadosCompletos;
import modelo.EmpleadoParcial;

public class Exportar {

    // Método para formatear los números a dos decimales
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void generarTXT(Empleado empleado) {
       
        String nombreArchivo = "nominas/" + empleado.getNombre().replace(" ", "_") + "_Nomina.txt";

        // Crear directorio si no existe
        java.io.File directorio = new java.io.File("nominas");
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("=== RECIBO DE NÓMINA ===\n");
            writer.write("Fecha: " + java.time.LocalDate.now() + "\n\n");
            writer.write("DATOS DEL EMPLEADO:\n");
            writer.write("Nombre: " + empleado.getNombre() + "\n");
            writer.write("Estado Civil: " + empleado.getEstadoCivil() + "\n");
            writer.write("Horas Trabajadas: " + empleado.getHorasTrabajadas() + " hrs\n");

            // Agregar información específica del tipo de empleado
            writer.write("\n=== LIQUIDACIÓN DE NÓMINA ===\n");

            if (empleado instanceof EmpleadosCompletos) {
                EmpleadosCompletos emp = (EmpleadosCompletos) empleado;
                double salarioBruto = emp.calcularSalarioBruto();
                double deducciones = emp.calcularDeducciones();
                double salarioNeto = emp.calcularSalarioNeto();
                double aportesEmpleador = emp.calcularAportesEmpleador();

                writer.write("DEVENGADO:\n");
                writer.write("Salario Base: $" + df.format(emp.getSalarioFijo()) + "\n");
                writer.write("Horas Trabajadas: " + emp.getHorasTrabajadas() + " hrs\n");
                writer.write("Salario Bruto: $" + df.format(salarioBruto) + "\n\n");

                writer.write("DEDUCCIONES:\n");
                writer.write("Salud (4%): $" + df.format(salarioBruto * 0.04) + "\n");
                writer.write("Pensión (4%): $" + df.format(salarioBruto * 0.04) + "\n");
                if (salarioBruto > (1424000 * 4)) {
                    writer.write("Fondo Solidaridad (1%): $" + df.format(salarioBruto * 0.01) + "\n");
                }
                writer.write("Total Deducciones: $" + df.format(deducciones) + "\n\n");
                writer.write("NETO A PAGAR: $" + df.format(salarioNeto) + "\n\n");

                writer.write("=== APORTES PATRONALES ===\n");
                writer.write("Salud (8.5%): $" + df.format(salarioBruto * 0.085) + "\n");
                writer.write("Pensión (12%): $" + df.format(salarioBruto * 0.12) + "\n");
                writer.write("Riesgos (0.522%): $" + df.format(salarioBruto * 0.00522) + "\n");
                writer.write("Parafiscales (9%): $" + df.format(salarioBruto * 0.09) + "\n");
                writer.write("Total Aportes: $" + df.format(aportesEmpleador) + "\n");
                writer.write("COSTO TOTAL DE NOMINA: $" + df.format(salarioBruto + aportesEmpleador) + "\n");

            } else if (empleado instanceof EmpleadoParcial) {
                EmpleadoParcial emp = (EmpleadoParcial) empleado;
                double salarioBruto = emp.calcularSalarioBruto();
                double deduccionesRecomendadas = emp.calcularDeduccionesRecomendadas();

                writer.write("DEVENGADO:\n");
                writer.write("Salario por Hora: $" + df.format(emp.getSalarioPorHora()) + "\n");
                writer.write("Horas Trabajadas: " + emp.getHorasTrabajadas() + " hrs\n");
                writer.write("Salario Bruto: $" + df.format(salarioBruto) + "\n\n");

                writer.write("=== INFORMACIÓN TRIBUTARIA ===\n");
                writer.write("DEDUCCIONES RECOMENDADAS:\n");
                writer.write("Salud (4%): $" + df.format(salarioBruto * 0.04) + "\n");
                writer.write("Pensión (4%): $" + df.format(salarioBruto * 0.04) + "\n");
                if (salarioBruto > (1424000 * 4)) {
                    writer.write("Fondo Solidaridad (1%): $" + df.format(salarioBruto * 0.01) + "\n");
                }
                writer.write("Total Recomendado: $" + df.format(deduccionesRecomendadas) + "\n");
                writer.write("\n*** Como trabajador independiente, debe realizar\n");
                writer.write("    estos aportes voluntariamente ***\n");
            }

        } catch (IOException e) {
            System.err.println("✗ Error al generar archivo: " + e.getMessage());
            throw new RuntimeException("Error al generar archivo TXT", e);
        }
    }
}
