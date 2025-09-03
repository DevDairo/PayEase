package modelo;

/**
 * Clase abstracta base para todos los tipos de empleados
 * Implementa los principios de POO: Abstracción, Encapsulamiento, Herencia
 * @author Enigma Group
 */
public abstract class Empleado {

    // Atributos básicos comunes - SIN FECHAS
    private String nombre;
    private String identificacion;
    private String estadoCivil;
    private double salarioHora;
    private double horasTrabajadas;
    private double horasExtras;
    private String nivelAcademico;

    // Constante para salario mínimo 2025
    private static final double SMLMV_2025 = 1423500.0;

    /**
     * Constructor completo
     */
    public Empleado(String nombre, String identificacion, String estadoCivil,
            double salarioHora, double horasTrabajadas, double horasExtras,
            String nivelAcademico) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.estadoCivil = estadoCivil;
        this.salarioHora = salarioHora;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtras = horasExtras;
        this.nivelAcademico = nivelAcademico;
    }

    /**
     * Constructor vacío
     */
    public Empleado() {
    }

    // MÉTODOS ABSTRACTOS - cada subclase los implementa diferente
    
    /**
     * Calcula el salario bruto según el tipo de empleado
     * @return Salario bruto calculado
     */
    public abstract double calcularSalarioBruto();

    /**
     * Determina si el empleado tiene prestaciones sociales
     * @return true si tiene prestaciones, false si no
     */
    public abstract boolean aplicaPrestacionesSociales();

    /**
     * Determina si el empleado tiene auxilio de transporte
     * @return true si tiene auxilio, false si no
     */
    public abstract boolean aplicaAuxilioTransporte();

    /**
     * Obtiene el tipo de contrato del empleado
     * @return Tipo de contrato como String
     */
    public abstract String getTipoContrato();

    // MÉTODOS CONCRETOS - comunes para todos los empleados
    
    /**
     * Calcula el valor de las horas extras con recargo del 25%
     * @return Valor total de horas extras
     */
    protected double calcularValorHorasExtras() {
        return horasExtras * (salarioHora * 1.25);
    }

    /**
     * Calcula el IBC (Ingreso Base de Cotización)
     * No puede ser menor al salario mínimo legal
     * @return IBC calculado
     */
    public double calcularIBC() {
        double salarioBruto = calcularSalarioBruto();
        return Math.max(salarioBruto, SMLMV_2025);
    }

    // GETTERS Y SETTERS
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        this.salarioHora = salarioHora;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public static double getSMLMV2025() {
        return SMLMV_2025;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", tipoContrato='" + getTipoContrato() + '\'' +
                ", nivelAcademico='" + nivelAcademico + '\'' +
                ", salarioBruto=" + calcularSalarioBruto() +
                '}';
    }
}