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
        // Generar un nombre de archivo único para cada empleado
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
            if (empleado instanceof EmpleadosCompletos) {
                EmpleadosCompletos emp = (EmpleadosCompletos) empleado;
                writer.write("Tipo de Contrato: Tiempo Completo\n");
                writer.write("Salario Fijo Mensual: $" + df.format(emp.getSalarioFijo()) + "\n");
            } else if (empleado instanceof EmpleadoParcial) {
                EmpleadoParcial emp = (EmpleadoParcial) empleado;
                writer.write("Tipo de Contrato: Tiempo Parcial\n");
                writer.write("Salario por Hora: $" + df.format(emp.getSalarioPorHora()) + "\n");
            }

            writer.write("\nCÁLCULOS:\n");
            writer.write("Salario Bruto: $" + df.format(empleado.calcularSalarioBruto()) + "\n");
            writer.write("\n*** Este recibo no incluye deducciones. ***\n");
            writer.write("=".repeat(45) + "\n");
            System.out.println("✓ Archivo generado: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("✗ Error al generar archivo: " + e.getMessage());
            throw new RuntimeException("Error al generar archivo TXT", e);
        }
    }
}
