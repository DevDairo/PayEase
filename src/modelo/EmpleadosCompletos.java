package modelo;

/**
 *
 * @author Enigma Group
 */
public class EmpleadosCompletos extends Empleado {

    // Atributo específico para empleados de tiempo completo
    private double salarioFijo;

    //Constructor
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
            /* Si trabajó menos horas, se descuenta proporcionalmente, 1,423,500/192=7,414.06*/ 
            return (this.salarioFijo / horasEstandar) * this.horasTrabajadas;
        } else {
            // Sitrabajó horas extras, se paga el 25% adicional por hora extra 
            double horasExtras = this.horasTrabajadas - horasEstandar;
            double valorHoraNormal = this.salarioFijo / horasEstandar;
            double valorHoraExtra = valorHoraNormal * 1.25;
            return this.salarioFijo + (horasExtras * valorHoraExtra);
        /* // Si trabaja más de 192 horas, se considera como horas extras. Cada hora extra se paga al 125% del valor de la hora normal (25% más). El salario fijo es $1,423,500, cada hora normal vale $7,414 y la hora extra vale $9,267.El salario bruto final será: salario fijo completo + (horas extra × valor hora extra).*/
        
        }
    }

    /* Método para calcular deducciones Aplica descuentos de ley al salario bruto:
    * Salud 4%
    * Pensión 4%
    * Solidaridad 1% (si supera 4 SMMLV)*/
    public double calcularDeducciones() {
        double salarioBruto = calcularSalarioBruto();
        double deduccionSalud = salarioBruto * 0.04;
        double deduccionPension = salarioBruto * 0.04;
        double deduccionSolidaridad = salarioBruto > (1424000 * 4) ? salarioBruto * 0.01 : 0;
        return deduccionSalud + deduccionPension + deduccionSolidaridad;
    }

    
   
    public double calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDeducciones();
        /* Devuelve el salario bruto menos las deducciones.*/
    }

    
    
    public double calcularAportesEmpleador() {
        double salarioBruto = calcularSalarioBruto();
        double aporteSalud = salarioBruto * 0.085;
        double aportePension = salarioBruto * 0.12;
        double aporteRiesgos = salarioBruto * 0.00522;
        double aporteParafiscales = salarioBruto * 0.09;
        return aporteSalud + aportePension + aporteRiesgos + aporteParafiscales;
        /*   Calcula lo que aporta el empleador adicional al salario bruto:
        * Salud 8.5%
        * Pensión 12%
        * Riesgos 0.522%
        * Parafiscales 9%*/
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
