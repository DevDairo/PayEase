package modelo;

/**
 *
 * @author Enigma Group
 */
public abstract class Empleado {

    protected String nombre;
    protected String estadoCivil;
    protected double horasTrabajadas;
    protected String id;



    public Empleado(String nombre, String id, String estadoCivil, double horasTrabajadas) {
        this.nombre = nombre;
        this.id = id;
        this.estadoCivil = estadoCivil;
        this.horasTrabajadas = horasTrabajadas;
    }
    
    
    /*En este método se aplica el concepto de polimorfismo. Cada tipo de empleado calculará su salario de manera diferente. Por ello, lo declaramos como abstracto, sin implementación.*/
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
    
        public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
