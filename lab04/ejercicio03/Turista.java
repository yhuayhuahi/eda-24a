public class Turista<T> {
    private String nombre;
    private T identificador;
    
    public Turista() {}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setIdentificador(T identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }
    public T getIdentificador() {
        return identificador;
    }
}
