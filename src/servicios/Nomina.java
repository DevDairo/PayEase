package servicios;

import modelo.Empleado;
import java.util.ArrayList;
import java.util.List;


public class Nomina {

    private List<Empleado> listaEmpleados;

    public Nomina() {
        this.listaEmpleados = new ArrayList<>();
    }

    public void registrarEmpleado(Empleado empleado) {
        this.listaEmpleados.add(empleado);
        System.out.println("Empleado " + empleado.getNombre() + " registrado en nómina.");
    }

    public void procesarNomina() {
        System.out.println("--- Procesando Nómina ---");
        for (Empleado empleado : listaEmpleados) {
            double salarioBruto = empleado.calcularSalarioBruto();
            System.out.println("Salario bruto de " + empleado.getNombre() + ": $" + salarioBruto);
        }
    }


    public List<Empleado> getListaEmpleados() {
        return this.listaEmpleados;
    }

}
