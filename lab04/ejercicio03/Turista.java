public class Turista<T> {
    private String nombre;
    private T DNI;
    
    public Turista(String nombre, T DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }
    public T getDNI() {
        return DNI;
    }
}