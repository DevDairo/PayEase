package modelo;

/**
 *
 * @author Enigma Group
 */
public class EmpleadosCompletos extends Empleado {

    // Atributo específico para empleados de tiempo completo
    private double salarioFijo;

    // Constructor que el IDE te ayudó a crear
    public EmpleadosCompletos(String nombre, String estadoCivil, double horasTrabajadas, double salarioFijo) {
        // Llama al constructor de la clase padre (Empleado)
        super(nombre, estadoCivil, horasTrabajadas);
        this.salarioFijo = salarioFijo;
    }

    // Implementación del método abstracto de la clase Empleado
    @Override
    public double calcularSalarioBruto() {
        // En este caso, el salario bruto es simplemente el salario fijo
        return this.salarioFijo;
    }

    // Método para obtener el salario fijo
    public double getSalarioFijo() {
        return salarioFijo;
    }

    // Método para establecer el salario fijo
    public void setSalarioFijo(double salarioFijo) {
        this.salarioFijo = salarioFijo;
    }
}
