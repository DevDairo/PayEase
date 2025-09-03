package modelo;

/**
 * Clase para empleados con contrato indefinido
 * Tienen todas las prestaciones sociales y aportes obligatorios
 * @author Enigma Group
 */
public class EmpleadoIndefinido extends Empleado {

    // Constantes para cálculos 2025
    private static final double AUXILIO_TRANSPORTE_2025 = 200000.0;
    private static final double DOS_SMLMV_2025 = getSMLMV2025() * 2; // $2.847.000

    /**
     * Constructor completo
     */
    public EmpleadoIndefinido(String nombre, String identificacion, String estadoCivil,
            double salarioHora, double horasTrabajadas, double horasExtras,
            String nivelAcademico) {
        super(nombre, identificacion, estadoCivil, salarioHora, horasTrabajadas, 
              horasExtras, nivelAcademico);
    }

    /**
     * Constructor vacío
     */
    public EmpleadoIndefinido() {
        super();
    }

    /**
     * Implementa el cálculo de salario bruto para empleados indefinidos
     * Incluye salario base + horas extras + auxilio de transporte
     */
    @Override
    public double calcularSalarioBruto() {
        double salarioBase = getSalarioHora() * getHorasTrabajadas();
        double valorHorasExtras = calcularValorHorasExtras();
        double auxilioTransporte = 0.0;
        
        // Calcular auxilio de transporte si aplica
        if (aplicaAuxilioTransporte()) {
            auxilioTransporte = AUXILIO_TRANSPORTE_2025;
        }
        
        return salarioBase + valorHorasExtras + auxilioTransporte;
    }

    /**
     * Los empleados indefinidos SÍ tienen prestaciones sociales
     */
    @Override
    public boolean aplicaPrestacionesSociales() {
        return true;
    }

    /**
     * Auxilio de transporte aplica si el salario base es <= 2 SMLMV
     * No incluye el auxilio en el cálculo para evitar recursión
     */
    @Override
    public boolean aplicaAuxilioTransporte() {
        double salarioBaseSinAuxilio = (getSalarioHora() * getHorasTrabajadas()) + 
                                       calcularValorHorasExtras();
        return salarioBaseSinAuxilio <= DOS_SMLMV_2025;
    }

    /**
     * Tipo de contrato
     */
    @Override
    public String getTipoContrato() {
        return "Contrato Indefinido";
    }

    /**
     * Calcula el valor del auxilio de transporte
     * @return Valor del auxilio si aplica, 0 si no aplica
     */
    public double calcularAuxilioTransporte() {
        return aplicaAuxilioTransporte() ? AUXILIO_TRANSPORTE_2025 : 0.0;
    }

    /**
     * Calcula las prestaciones sociales mensuales
     * @return Valor total de prestaciones del mes
     */
    public double calcularPrestacionesSociales() {
        double salarioBaseSinAuxilio = (getSalarioHora() * getHorasTrabajadas()) + 
                                       calcularValorHorasExtras();
        
        // Prestaciones se calculan sobre salario sin auxilio de transporte
        double cesantias = salarioBaseSinAuxilio * 0.0833; // 8.33% mensual
        double interesesCesantias = cesantias * 0.01; // 1% anual de cesantías
        double prima = salarioBaseSinAuxilio * 0.0833; // 8.33% mensual
        double vacaciones = salarioBaseSinAuxilio * 0.0417; // 4.17% mensual
        
        return cesantias + interesesCesantias + prima + vacaciones;
    }

    /**
     * Calcula las deducciones de seguridad social del empleado
     * @return Total de deducciones (salud + pensión)
     */
    public double calcularDeduccionesEmpleado() {
        double ibc = calcularIBC();
        double salud = ibc * 0.04; // 4%
        double pension = ibc * 0.04; // 4%
        return salud + pension;
    }

    /**
     * Calcula los aportes patronales
     * @return Total aportes que debe pagar el empleador
     */
    public double calcularAportesEmpleador() {
        double ibc = calcularIBC();
        double salud = ibc * 0.085; // 8.5%
        double pension = ibc * 0.12; // 12%
        double arl = ibc * 0.00522; // 0.522%
        double parafiscales = ibc * 0.09; // 9% (SENA + ICBF + Caja)
        return salud + pension + arl + parafiscales;
    }

    /**
     * Calcula el salario neto final
     * @return Salario bruto - deducciones del empleado
     */
    public double calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDeduccionesEmpleado();
    }

    @Override
    public String toString() {
        return "EmpleadoIndefinido{" +
                "nombre='" + getNombre() + '\'' +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", salarioBruto=" + calcularSalarioBruto() +
                ", salarioNeto=" + calcularSalarioNeto() +
                ", prestaciones=" + aplicaPrestacionesSociales() +
                ", auxilioTransporte=" + aplicaAuxilioTransporte() +
                '}';
    }
}