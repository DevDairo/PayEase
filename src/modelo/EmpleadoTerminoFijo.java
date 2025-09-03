
package modelo;

import java.util.Date;

public class EmpleadoTerminoFijo {


    private Date fechaFinContrato;
    private boolean aplicaPrestaciones;
    private boolean aplicaAuxilioTransporte;    
    
    
    public EmpleadoTerminoFijo(Date fechaFinContrato, boolean aplicaPrestaciones, boolean aplicaAuxilioTransporte) {
        this.fechaFinContrato = fechaFinContrato;
        this.aplicaPrestaciones = aplicaPrestaciones;
        this.aplicaAuxilioTransporte = aplicaAuxilioTransporte;
    }
    
    
}
