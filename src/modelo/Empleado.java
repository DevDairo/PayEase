package modelo;

/**
 *
 * @author Enigma Group
 */
public abstract class Empleado {

    protected String nombre;
    protected String estadoCivil;
    protected double horasTrabajadas;

    public Empleado(String nombre, String estadoCivil, double horasTrabajadas) {
        this.nombre = nombre;
        this.estadoCivil = estadoCivil;
        this.horasTrabajadas = horasTrabajadas;
    }

    /*Este método es el corazón del polimorfismo en tu proyecto. Cada tipo de empleado calculará su salario de manera diferente. Por ello, lo declaramos como abstracto, sin implementación.*/
    public abstract double calcularSalarioBruto();   
    
    /*Getters y Setters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }


}
