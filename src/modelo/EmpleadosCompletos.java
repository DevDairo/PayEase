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
        double horasEstandar = 192; // 8 horas x 24 días laborales

        if (this.horasTrabajadas <= horasEstandar) {
            // Si trabajó menos horas, se descuenta proporcionalmente
            return (this.salarioFijo / horasEstandar) * this.horasTrabajadas;
        } else {
            // Si trabajó horas extras, se paga el 25% adicional por hora extra
            double horasExtras = this.horasTrabajadas - horasEstandar;
            double valorHoraNormal = this.salarioFijo / horasEstandar;
            double valorHoraExtra = valorHoraNormal * 1.25;
            return this.salarioFijo + (horasExtras * valorHoraExtra);
        }
    }

    // Método para calcular deducciones
    public double calcularDeducciones() {
        double salarioBruto = calcularSalarioBruto();
        double deduccionSalud = salarioBruto * 0.04;
        double deduccionPension = salarioBruto * 0.04;
        double deduccionSolidaridad = salarioBruto > (1424000 * 4) ? salarioBruto * 0.01 : 0;
        return deduccionSalud + deduccionPension + deduccionSolidaridad;
    }

    public double calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDeducciones();
    }

    public double calcularAportesEmpleador() {
        double salarioBruto = calcularSalarioBruto();
        double aporteSalud = salarioBruto * 0.085;
        double aportePension = salarioBruto * 0.12;
        double aporteRiesgos = salarioBruto * 0.00522;
        double aporteParafiscales = salarioBruto * 0.09;
        return aporteSalud + aportePension + aporteRiesgos + aporteParafiscales;
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
