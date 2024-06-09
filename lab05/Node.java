public class Node<T> {

    private T dato;
    private Node<T> derecha;
    private Node<T> izquierda;

    public Node(T dato) {
        this.dato = dato;
        this.derecha = null;
        this.izquierda = null;
        System.out.println(dato);
    }

    public T getDato() {
        return this.dato;
    }
    public void setDato(T dato) {
        this.dato = dato;
    }

    public Node<T> getDerecha() {
        return this.derecha;
    }
    public void setDerecha(Node<T> derecha) {
        this.derecha = derecha;
    }

    public Node<T> getIzquierda() {
        return this.izquierda;
    }
    public void setIzquierda(Node<T> izquierda) {
        this.izquierda = izquierda;
    }

}