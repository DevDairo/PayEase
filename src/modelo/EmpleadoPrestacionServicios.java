package modelo;

/**
 * Clase para empleados con contrato por prestación de servicios
 * NO tienen prestaciones sociales, auxilio de transporte ni deducciones obligatorias
 * Son contratistas independientes
 * @author Enigma Group
 */
public class EmpleadoPrestacionServicios extends Empleado {

    /**
     * Constructor completo
     */
    public EmpleadoPrestacionServicios(String nombre, String identificacion, String estadoCivil,
            double salarioHora, double horasTrabajadas, double horasExtras,
            String nivelAcademico) {
        super(nombre, identificacion, estadoCivil, salarioHora, horasTrabajadas, 
              horasExtras, nivelAcademico);
    }

    /**
     * Constructor vacío
     */
    public EmpleadoPrestacionServicios() {
        super();
    }

    /**
     * Implementa el cálculo de salario bruto para prestación de servicios
     * Solo incluye: salario base + horas extras
     * NO incluye auxilio de transporte ni prestaciones
     */
    @Override
    public double calcularSalarioBruto() {
        double salarioBase = getSalarioHora() * getHorasTrabajadas();
        double valorHorasExtras = calcularValorHorasExtras();
        
        return salarioBase + valorHorasExtras;
    }

    /**
     * Los contratistas por prestación de servicios NO tienen prestaciones sociales
     */
    @Override
    public boolean aplicaPrestacionesSociales() {
        return false;
    }

    /**
     * Los contratistas por prestación de servicios NO tienen auxilio de transporte
     */
    @Override
    public boolean aplicaAuxilioTransporte() {
        return false;
    }

    /**
     * Tipo de contrato
     */
    @Override
    public String getTipoContrato() {
        return "Prestación de Servicios";
    }

    /**
     * Auxilio de transporte para prestación de servicios
     * @return Siempre 0, no aplica
     */
    public double calcularAuxilioTransporte() {
        return 0.0;
    }

    /**
     * Prestaciones sociales para prestación de servicios
     * @return Siempre 0, no aplican
     */
    public double calcularPrestacionesSociales() {
        return 0.0;
    }

    /**
     * Deducciones del empleado para prestación de servicios
     * @return Siempre 0, no hay deducciones obligatorias
     */
    public double calcularDeduccionesEmpleado() {
        return 0.0;
    }

    /**
     * Aportes patronales para prestación de servicios
     * @return Siempre 0, no hay aportes obligatorios del contratante
     */
    public double calcularAportesEmpleador() {
        return 0.0;
    }

    /**
     * Calcula el salario neto final
     * Para prestación de servicios: salario neto = salario bruto
     * (no hay deducciones)
     */
    public double calcularSalarioNeto() {
        return calcularSalarioBruto(); // Sin deducciones
    }

    /**
     * Información sobre responsabilidades del contratista
     * @return Mensaje informativo
     */
    public String getResponsabilidadesContratista() {
        return "El contratista es responsable de sus propios aportes a seguridad social, " +
               "declaración de renta y demás obligaciones tributarias.";
    }

    /**
     * Verifica si el contratista debería cotizar por su cuenta
     * Según normativa colombiana, si gana más de 1 SMLMV debe cotizar
     * @return true si debería cotizar, false si no
     */
    public boolean deberiaComprarSeguridadSocial() {
        return calcularSalarioBruto() >= getSMLMV2025();
    }

    /**
     * Calcula sugerencia de ahorro para seguridad social
     * Sugerencia: 16% del salario bruto (12% pensión + 4% salud mínimo)
     * @return Valor sugerido para ahorrar mensualmente
     */
    public double calcularSugerenciaAhorroSeguridadSocial() {
        if (deberiaComprarSeguridadSocial()) {
            return calcularSalarioBruto() * 0.16; // 16% sugerido
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "EmpleadoPrestacionServicios{" +
                "nombre='" + getNombre() + '\'' +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", salarioBruto=" + calcularSalarioBruto() +
                ", salarioNeto=" + calcularSalarioNeto() +
                ", prestaciones=" + aplicaPrestacionesSociales() +
                ", auxilioTransporte=" + aplicaAuxilioTransporte() +
                ", deberiaComprarSS=" + deberiaComprarSeguridadSocial() +
                '}';
    }
}