package modelo;

public class EmpleadoParcial extends Empleado {

    // Atributo específico para empleados de tiempo parcial
    private double salarioPorHora;

    // Constructor generado automáticamente por el IDE
    public EmpleadoParcial(String nombre, String estadoCivil, double horasTrabajadas, double salarioPorHora) {
        // Llama al constructor de la clase padre (Empleado)
        super(nombre, estadoCivil, horasTrabajadas);
        this.salarioPorHora = salarioPorHora;
    }

    // Implementación del método abstracto de la clase Empleado
    @Override
    public double calcularSalarioBruto() {
        // El salario bruto se calcula multiplicando las horas trabajadas por el salario por hora
        return this.horasTrabajadas * this.salarioPorHora;
    }

    // Método para obtener el salario por hora
    public double getSalarioPorHora() {
        return salarioPorHora;
    }

    // Método para establecer el salario por hora
    public void setSalarioPorHora(double salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }

    // Para tiempo parcial solo se calcula el bruto y se informa sobre deducciones recomendadas
    public double calcularDeduccionesRecomendadas() {
        double salarioBruto = calcularSalarioBruto();
        double deduccionSalud = salarioBruto * 0.04;
        double deduccionPension = salarioBruto * 0.04;
        double deduccionSolidaridad = salarioBruto > (1424000 * 4) ? salarioBruto * 0.01 : 0;
        return deduccionSalud + deduccionPension + deduccionSolidaridad;
    }

}
