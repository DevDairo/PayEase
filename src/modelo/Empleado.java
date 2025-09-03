package modelo;

import java.util.Date;

public class Empleado {

    // Atributos básicos
    private String nombre;
    private String identificacion;
    private String estadoCivil;
    private double salarioHora;
    private double horasTrabajadas;
    private double horasExtras;
    private Date fechaIngreso;
    private String tipoContrato;
    private String nivelAcademico;

    // Constructor completo
    public Empleado(String nombre, String identificacion, String estadoCivil,
            double salarioHora, double horasTrabajadas, double horasExtras,
            Date fechaIngreso, String tipoContrato, String nivelAcademico) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.estadoCivil = estadoCivil;
        this.salarioHora = salarioHora;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtras = horasExtras;
        this.fechaIngreso = fechaIngreso;
        this.tipoContrato = tipoContrato;
        this.nivelAcademico = nivelAcademico;
    }

    // Constructor sin fecha (usa fecha actual)
    public Empleado(String nombre, String identificacion, String estadoCivil,
            double salarioHora, double horasTrabajadas, double horasExtras,
            String tipoContrato, String nivelAcademico) {
        this(nombre, identificacion, estadoCivil, salarioHora, horasTrabajadas,
                horasExtras, new Date(), tipoContrato, nivelAcademico);
    }

    /**
     * Método para calcular el salario bruto base
     *
     * @return Salario bruto calculado
     */
    public double calcularSalarioBruto() {
        double salarioNormal = salarioHora * horasTrabajadas;
        double valorHorasExtras = calcularValorHorasExtras();
        return salarioNormal + valorHorasExtras;
    }

    /**
     * Calcula el valor de las horas extras con recargo del 25%
     *
     * @return Valor total de horas extras
     */
    protected double calcularValorHorasExtras() {
        // Hora extra diurna: valor hora * 1.25
        return horasExtras * (salarioHora * 1.25);
    }

    /**
     * Método para obtener el IBC (Ingreso Base de Cotización)
     *
     * @return IBC calculado
     */
    public double calcularIBC() {
        double salarioBruto = calcularSalarioBruto();
        // El IBC no puede ser menor al salario mínimo
        double salarioMinimo = 1300000; // SMLMV 2024 Colombia
        return Math.max(salarioBruto, salarioMinimo);
    }

    // Getters y Setters
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

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    @Override
    public String toString() {
        return "Empleado{"
                + "nombre='" + nombre + '\''
                + ", identificacion='" + identificacion + '\''
                + ", tipoContrato='" + tipoContrato + '\''
                + ", salarioBruto=" + calcularSalarioBruto()
                + '}';
    }
}
