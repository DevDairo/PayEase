package servicios;

import modelo.Empleado;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpleadoParcial; // Importar la clase EmpleadoParcial
import modelo.EmpleadosCompletos; // Importar la clase EmpleadosCompletos


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
    
    // Dentro de la clase Nomina
    public List<Empleado> getListaEmpleados() {
    return this.listaEmpleados;
    }

}