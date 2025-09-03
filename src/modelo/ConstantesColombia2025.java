package modelo;

/**
 * Constantes oficiales para cálculos de nómina Colombia 2025
 * Valores actualizados según decretos gubernamentales
 * @author Enigma Group
 */
public class ConstantesColombia2025 {
    
    // SALARIO MÍNIMO LEGAL 2025
    public static final double SMLMV_2025 = 1423500.0;
    public static final double DOS_SMLMV_2025 = SMLMV_2025 * 2; // $2.847.000
    
    // AUXILIO DE TRANSPORTE 2025
    public static final double AUXILIO_TRANSPORTE_2025 = 200000.0;
    
    // APORTES DEL EMPLEADO (se descuentan del salario)
    public static final double SALUD_EMPLEADO = 0.04; // 4%
    public static final double PENSION_EMPLEADO = 0.04; // 4%
    
    // APORTES DEL EMPLEADOR (a cargo de la empresa)
    public static final double SALUD_EMPLEADOR = 0.085; // 8.5%
    public static final double PENSION_EMPLEADOR = 0.12; // 12%
    public static final double ARL = 0.00522; // 0.522%
    
    // APORTES PARAFISCALES (a cargo del empleador)
    public static final double SENA = 0.02; // 2%
    public static final double ICBF = 0.03; // 3%
    public static final double CAJA_COMPENSACION = 0.04; // 4%
    public static final double TOTAL_PARAFISCALES = SENA + ICBF + CAJA_COMPENSACION; // 9%
    
    // PRESTACIONES SOCIALES (porcentajes mensuales)
    public static final double CESANTIAS_MENSUAL = 0.0833; // 8.33%
    public static final double INTERESES_CESANTIAS_ANUAL = 0.01; // 1% anual
    public static final double PRIMA_SERVICIOS = 0.0833; // 8.33%
    public static final double VACACIONES = 0.0417; // 4.17%
    
    // RECARGO HORAS EXTRAS
    public static final double RECARGO_HORA_EXTRA_DIURNA = 1.25; // 25% adicional
    
    /**
     * Verifica si un salario aplica para auxilio de transporte
     */
    public static boolean aplicaAuxilioTransporte(double salarioMensual) {
        return salarioMensual <= DOS_SMLMV_2025;
    }
    
    /**
     * Calcula las deducciones del empleado (salud + pensión)
     */
    public static double calcularDeduccionesEmpleado(double ibc) {
        return (ibc * SALUD_EMPLEADO) + (ibc * PENSION_EMPLEADO);
    }
    
    /**
     * Calcula los aportes del empleador (salud + pensión + ARL + parafiscales)
     */
    public static double calcularAportesEmpleador(double ibc) {
        return (ibc * SALUD_EMPLEADOR) + 
               (ibc * PENSION_EMPLEADOR) + 
               (ibc * ARL) + 
               (ibc * TOTAL_PARAFISCALES);
    }
    
    /**
     * Calcula las prestaciones sociales mensuales
     */
    public static double calcularPrestacionesMensuales(double salarioBase) {
        double cesantias = salarioBase * CESANTIAS_MENSUAL;
        double interesesCesantias = cesantias * (INTERESES_CESANTIAS_ANUAL / 12); // Mensual
        double prima = salarioBase * PRIMA_SERVICIOS;
        double vacaciones = salarioBase * VACACIONES;
        
        return cesantias + interesesCesantias + prima + vacaciones;
    }
    
    /**
     * Calcula el IBC (no menor al salario mínimo)
     */
    public static double calcularIBC(double salarioBruto) {
        return Math.max(salarioBruto, SMLMV_2025);
    }
}