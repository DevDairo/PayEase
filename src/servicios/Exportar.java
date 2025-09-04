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
        String nombreArchivo = empleado.getNombre().replace(" ", "_") + "_Nomina.txt";
        
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("--- Recibo de Nómina ---\n\n");
            writer.write("Nombre: " + empleado.getNombre() + "\n");
            writer.write("Estado Civil: " + empleado.getEstadoCivil() + "\n");
            writer.write("Tipo de Contrato: ");
            
            // Determinar el tipo de empleado para la exportación
            if (empleado instanceof EmpleadosCompletos) {
                writer.write("Tiempo Completo\n");
            } else if (empleado instanceof EmpleadoParcial) {
                writer.write("Tiempo Parcial\n");
            }
            
            writer.write("Horas Trabajadas: " + empleado.getHorasTrabajadas() + "\n");
            writer.write("Salario Bruto: $" + df.format(empleado.calcularSalarioBruto()) + "\n");
            
            // La siguiente lógica es para el requisito pendiente de las deducciones de impuestos,
            // que aún no hemos implementado. Puedes agregarla en el futuro.
            
            writer.write("\n*** Este recibo no incluye deducciones de impuestos. ***\n");
            
            writer.flush();
            System.out.println("Archivo " + nombreArchivo + " creado correctamente.");
            
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}